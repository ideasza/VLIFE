package teerayut.dev.vlife.fragment.firstpage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.thekhaeng.recyclerviewmargin.StaggeredGridLayoutMargin;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpFragment;
import teerayut.dev.vlife.utils.Config;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment<HomeFragmentInterface.Presenter> implements HomeFragmentInterface.View {


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
    @Override
    public void bindView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void setupInstance() {

    }

    @Override
    public void setupView() {
        setRecyclerView();
        tryAgain.setOnClickListener( onTryAgain() );
    }

    @Override
    public void initialize() {

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

            }
        };
    }

}
