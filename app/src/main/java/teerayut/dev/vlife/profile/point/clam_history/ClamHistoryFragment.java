package teerayut.dev.vlife.profile.point.clam_history;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.profile.point.clam_history.adapter.ClamHistoryAdapter;
import teerayut.dev.vlife.profile.point.clam_history.item.ClamItem;
import teerayut.dev.vlife.utils.Config;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClamHistoryFragment extends Fragment implements ClamHistoryInterface.View {

    public static ClamHistoryFragment newInstance() {
        return new ClamHistoryFragment();
    }

    public ClamHistoryFragment() {
        // Required empty public constructor
    }

    private View view;
    private ClamHistoryAdapter adapter;
    private ClamHistoryInterface.Presenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_clam_history, container, false);
        bindView();
        return view;
    }

    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    @BindView(R.id.container_service_unavailable) FrameLayout containerUnvailable;
    private void bindView() {
        ButterKnife.bind(this, view);
        setInstance();
        setView();
    }

    private void setInstance() {
        presenter = new ClamHistoryPresenter(this);
    }

    private void setView() {
        StaggeredGridLayoutManager layout = new StaggeredGridLayoutManager( Config.COLUMN_ONE, StaggeredGridLayoutManager.VERTICAL );
        recyclerView.setLayoutManager( layout );
        presenter.requestClamHistory();
    }

    @Override
    public void showUnvailable() {
        recyclerView.setVisibility( View.GONE );
        containerUnvailable.setVisibility( View.VISIBLE );
    }

    @Override
    public void showAvailable() {
        recyclerView.setVisibility( View.VISIBLE );
        containerUnvailable.setVisibility( View.GONE );
    }

    @Override
    public void setClamHistoryToAdapter(List<ClamItem> clamItemList) {
        adapter = new ClamHistoryAdapter(getActivity(), clamItemList);
        recyclerView.setAdapter(adapter);
    }
}
