package teerayut.dev.vlife.profile.point.clam_history;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClamHistoryFragment extends Fragment {

    public static ClamHistoryFragment newInstance() {
        return new ClamHistoryFragment();
    }

    public ClamHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clam_history, container, false);
    }

}
