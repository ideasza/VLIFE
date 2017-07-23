package teerayut.dev.vlife.profile.point.point_history;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PointHistoryFragment extends Fragment {

    public static PointHistoryFragment newInstance() {
        return new PointHistoryFragment();
    }

    public PointHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_point_history, container, false);
    }

}
