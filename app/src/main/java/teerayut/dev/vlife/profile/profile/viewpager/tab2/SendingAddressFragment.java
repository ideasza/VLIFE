package teerayut.dev.vlife.profile.profile.viewpager.tab2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendingAddressFragment extends Fragment {

    public static SendingAddressFragment newInstance() {
        return new SendingAddressFragment();
    }

    public SendingAddressFragment() {
        // Required empty public constructor
    }

    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sending_address, container, false);
        return view;
    }

}
