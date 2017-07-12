package teerayut.dev.vlife.payment.delivery;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
    private onClickButtonNext clickButtonNext;
    @BindView(R.id.group_delivery) RadioGroup groupDelivery;
    @BindView(R.id.group_address) RadioGroup groupAddress;
    @BindView(R.id.radio_msn) RadioButton radioMassenger;
    @BindView(R.id.radio_ems) RadioButton radioEMS;
    @BindView(R.id.radio_address) RadioButton radioAddress;
    @BindView(R.id.radio_add) RadioButton radioAdd;
    @BindView(R.id.address) View existAddress;
    @BindView(R.id.insert_address) View insertAddress;
    @BindView(R.id.image_delivery) ImageView imageDelivery;
    @BindView(R.id.button_delivery_next) Button buttonNext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_delivery, container, false);
        bindView(view);
        return view;
    }

    private void bindView(View view) {
        ButterKnife.bind(this, view);
        imageDelivery.setVisibility(View.GONE);
        radioMassenger.setOnClickListener( OptionDeliveryOnClickListener );
        radioEMS.setOnClickListener( OptionDeliveryOnClickListener );
        radioAddress.setOnClickListener( OptionOnClickListener );
        radioAdd.setOnClickListener( OptionOnClickListener );
        buttonNext.setOnClickListener( onNext() );
    }


    RadioButton.OnClickListener OptionOnClickListener = new RadioButton.OnClickListener() {
        public void onClick(View v) {
            if (radioAddress.isChecked()) {
                existAddress.setVisibility(View.VISIBLE);
                insertAddress.setVisibility(View.GONE);
            } else {
                radioAddress.setChecked(false);
                existAddress.setVisibility(View.GONE);
                insertAddress.setVisibility(View.VISIBLE);
            }
        }
    };

    RadioButton.OnClickListener OptionDeliveryOnClickListener = new RadioButton.OnClickListener() {
        public void onClick(View v) {
            if (radioMassenger.isChecked()) {
                imageDelivery.setVisibility(View.VISIBLE);
                imageDelivery.setImageDrawable(getResources().getDrawable(R.drawable.kerry));
            } else {
                radioMassenger.setChecked(false);
                imageDelivery.setVisibility(View.VISIBLE);
                imageDelivery.setImageDrawable(getResources().getDrawable(R.drawable.ems));
            }
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            clickButtonNext = (onClickButtonNext) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(((Activity) context).getLocalClassName()
                    + " DeliveryFragment implement OnButtonClickListener");
        }
    }

    private View.OnClickListener onNext() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickButtonNext.OnClickButtonNext(view);
            }
        };
    }

    public interface onClickButtonNext{
        void OnClickButtonNext(View view);
    }
}
