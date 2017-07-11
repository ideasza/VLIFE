package teerayut.dev.vlife.payment.delivery;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.fragment.home.HomeInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryFragment extends Fragment {


    public DeliveryFragment() {
        // Required empty public constructor
    }

    public static DeliveryFragment newInstance() {
        return new DeliveryFragment();
    }

    private View view;
    @BindView(R.id.group_delivery) RadioGroup groupDelivery;
    @BindView(R.id.group_address) RadioGroup groupAddress;
    @BindView(R.id.radio_msn) RadioButton radioMassenger;
    @BindView(R.id.radio_ems) RadioButton radioEMS;
    @BindView(R.id.radio_address) RadioButton radioAddress;
    @BindView(R.id.radio_add) RadioButton radioAdd;
    @BindView(R.id.form) NestedScrollView scrollViewForm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_delivery, container, false);
        bindView(view);
        return view;
    }

    private void bindView(View view) {
        ButterKnife.bind(this, view);
        groupAddress.setOnClickListener( onCheckAddress() );
    }

    private void setForm() {
        LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View insertAddress = inflater.inflate(R.layout.form_insert_address, null);
        View address = inflater.inflate(R.layout.form_address, null);

        if (radioAdd.isChecked()) {
            scrollViewForm.addView(insertAddress);
        } else if (radioAddress.isChecked()) {
            scrollViewForm.addView(address);
        }
    }

    private View.OnClickListener onCheckAddress() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setForm();
            }
        };
    }
}
