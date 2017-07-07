package teerayut.dev.vlife.fragment.firstpage;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.thekhaeng.recyclerviewmargin.StaggeredGridLayoutMargin;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpFragment;
import teerayut.dev.vlife.fragment.firstpage.adapter.ProductAdapter;
import teerayut.dev.vlife.fragment.firstpage.item.Item;
import teerayut.dev.vlife.utils.Alert;
import teerayut.dev.vlife.utils.Config;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment<HomeFragmentInterface.Presenter> implements HomeFragmentInterface.View {

    private ProductAdapter adapter;
    private List<Item> itemList = new ArrayList<Item>();

    public HomeFragment() {
        super();
    }

    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public HomeFragmentInterface.Presenter createPresenter() {
        return HomeFragmentPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_home;
    }

    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    @BindView(R.id.container_service_unavailable) View containerServiceUnavailable;
    @BindView(R.id.btn_try_again) Button tryAgain;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout refreshLayout;
    @Override
    public void bindView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void setupInstance() {
        refreshLayout.setColorSchemeResources(
                R.color.DarkCyan,
                R.color.DeepPink,
                R.color.LimeGreen,
                R.color.colorPrimaryDark);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //recyclerView.setAdapter(null);
                //getPresenter().requestProduct();
            }
        });
    }

    @Override
    public void setupView() {
        setRecyclerView();
        tryAgain.setOnClickListener( onTryAgain() );
    }

    @Override
    public void initialize() {
        Alert.dialogLoading(getActivity());
        getPresenter().requestProduct();
    }

    private void setRecyclerView() {
        int itemSpace = (int) getResources().getDimension( R.dimen.default_padding_margin );
        recyclerView.addItemDecoration( new StaggeredGridLayoutMargin(Config.COLUMN_COUNT, itemSpace ) );
        StaggeredGridLayoutManager layout = new StaggeredGridLayoutManager( Config.COLUMN_COUNT, StaggeredGridLayoutManager.VERTICAL );
        recyclerView.setLayoutManager( layout );
    }

    private View.OnClickListener onTryAgain() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().requestProduct();
            }
        };
    }

    @Override
    public void setProductList(List<Item> itemList) {
        this.itemList = itemList;
        adapter = new ProductAdapter(getActivity(), itemList);
        adapter.setOnClickProductItem( onClickProduct() );
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        if (refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(false);
        }
        Alert.dialogDimiss();
    }

    @NonNull
    private ProductAdapter.OnProductClickListener onClickProduct(){
        return new ProductAdapter.OnProductClickListener(){
            @Override
            public void onClickItem(Context item, int position ){
                Toast.makeText( getActivity(), "Item " + position, Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onClickAddToCart(Context item, int position ){
                Toast.makeText( getActivity(), "Item " + position, Toast.LENGTH_SHORT ).show();
                //getPresenter().addBeerItemToCart( item );
            }

            @Override
            public void onClickAdded(Context item, int position ){
                Toast.makeText( getActivity(), "Item " + position, Toast.LENGTH_SHORT ).show();
                //getPresenter().deleteBeerItemFromCart( item, position );
            }
        };
    }
}
