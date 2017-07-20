package teerayut.dev.vlife.profile.commission.day;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DayCommissionFragment extends Fragment {


    public DayCommissionFragment() {
        // Required empty public constructor
    }

    public static DayCommissionFragment newInstance() {
        return new DayCommissionFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_day_commission, container, false);
    }

}
