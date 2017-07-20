package teerayut.dev.vlife.profile.commission.travel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TravelCommissionFragment extends Fragment {


    public TravelCommissionFragment() {
        // Required empty public constructor
    }

    public static TravelCommissionFragment newInstance() {
        return new TravelCommissionFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_travel_commission, container, false);
    }

}
