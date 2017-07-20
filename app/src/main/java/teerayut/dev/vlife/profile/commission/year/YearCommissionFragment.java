package teerayut.dev.vlife.profile.commission.year;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class YearCommissionFragment extends Fragment {


    public YearCommissionFragment() {
        // Required empty public constructor
    }

    public static YearCommissionFragment newInstance() {
        return new YearCommissionFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_year_commission, container, false);
    }

}
