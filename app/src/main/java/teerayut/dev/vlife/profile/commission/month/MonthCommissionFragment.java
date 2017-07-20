package teerayut.dev.vlife.profile.commission.month;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonthCommissionFragment extends Fragment {


    public MonthCommissionFragment() {
        // Required empty public constructor
    }

    public static MonthCommissionFragment newInstance() {
        return new MonthCommissionFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_month_commission, container, false);
    }

}
