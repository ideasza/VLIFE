package teerayut.dev.vlife.profile.order_history;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderHistoryFragment extends Fragment {


    public OrderHistoryFragment() {
        // Required empty public constructor
    }

    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_order_history, container, false);
        bindView();
        return view;
    }

    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    private void bindView() {
        ButterKnife.bind(this, view);
    }

}
