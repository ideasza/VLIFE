package teerayut.dev.vlife.news;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.squareup.otto.Subscribe;
import com.thekhaeng.recyclerviewmargin.StaggeredGridLayoutMargin;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.news.adapter.NewsAdapter;
import teerayut.dev.vlife.news.detail.NewsDetailActivity;
import teerayut.dev.vlife.news.item.NewsItem;
import teerayut.dev.vlife.utils.ActivityResultBus;
import teerayut.dev.vlife.utils.ActivityResultEvent;
import teerayut.dev.vlife.utils.Config;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements NewsInterface.View, NewsAdapter.OnClickNewsItemListener {

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        bindView(view);
        return view;
    }

    private NewsAdapter adapter;
    private NewsInterface.Presenter presenter;
    private List<NewsItem> newsItemList = new ArrayList<NewsItem>();
    @BindView(R.id.btn_try_again) Button buttonTryAgain;
    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    @BindView(R.id.container_service_unavailable) FrameLayout serviceUnvailable;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;
    private void bindView(View view) {
        ButterKnife.bind(this, view);
        setView();
        setInstance();
    }

    private void setView() {
        serviceUnvailable.setVisibility(View.VISIBLE);
        buttonTryAgain.setOnClickListener( onTryAgain() );
    }

    private void setInstance() {
        presenter = new NewsPresenter(this);
        presenter.requestNews();
    }

    @Override
    public void setItemToRecyclerView(List<NewsItem> modelList) {
        this.newsItemList = modelList;
        adapter = new NewsAdapter(getActivity(), newsItemList);
        int itemSpace = (int) getResources().getDimension( R.dimen.default_padding_margin );
        recyclerView.addItemDecoration( new StaggeredGridLayoutMargin(Config.COLUMN_ONE, itemSpace ) );
        StaggeredGridLayoutManager layout = new StaggeredGridLayoutManager( Config.COLUMN_ONE, StaggeredGridLayoutManager.VERTICAL );
        recyclerView.setLayoutManager( layout );
        recyclerView.setAdapter(adapter);
        if (newsItemList.size() > 0) {
            serviceUnvailable.setVisibility(View.GONE);
        }
        adapter.setOnClickNewsItemListener(this);
    }

    @Override
    public void showUnvailable() {
        recyclerView.setVisibility( View.GONE );
        serviceUnvailable.setVisibility( View.VISIBLE );
    }

    @Override
    public void showAvailable() {
        recyclerView.setVisibility( View.VISIBLE );
        serviceUnvailable.setVisibility( View.GONE );
    }

    @Override
    public void onStart() {
        super.onStart();
        ActivityResultBus.getInstance().register(mActivityResultSubscriber);
    }

    @Override
    public void onStop() {
        super.onStop();
        ActivityResultBus.getInstance().unregister(mActivityResultSubscriber);
    }

    private Object mActivityResultSubscriber = new Object() {
        @Subscribe
        public void onActivityResultReceived(ActivityResultEvent event) {
            int requestCode = event.getRequestCode();
            int resultCode = event.getResultCode();
            Intent data = event.getData();
            onActivityResult(requestCode, resultCode, data);
        }
    };

    private View.OnClickListener onTryAgain() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.requestNews();
            }
        };
    }

    @Override
    public void clickNewsItem(View view, int position) {
        NewsItem item = newsItemList.get(position);
        Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
        intent.putExtra(Config.KEY_NEWS_ITEM_DETAIL, item);
        getActivity().startActivityForResult(intent, Config.REQUEST_NEWS_DETAIL);
    }
}
