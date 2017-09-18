package teerayut.dev.vlife.cart.payment.delivery;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpFragment;
import teerayut.dev.vlife.cart.payment.delivery.item.ThailandItem;
import teerayut.dev.vlife.customadapter.SpinnerCustomAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryFragment extends BaseMvpFragment<DeliveryInterface.Presenter> implements DeliveryInterface.View {
    /**
     * Insert form
     */
    private EditText editTextName;
    private EditText editTextPhone;
    private EditText editTextNumber;
    private EditText editTextBuilding;
    private EditText editTextVillage;
    private EditText editTextSoi;
    private EditText editTextRoad;
    private EditText editTextZipcode;
    private Spinner sub_districtSpinner;
    private Spinner districtSpinner;
    private Spinner provinceSpinner;
    /**
     * End
     */

    private String deliveryBy;
    private SpinnerCustomAdapter spinnerCustomAdapter;

    public DeliveryFragment() {
        // Required empty public constructor
    }

    public static DeliveryFragment newInstance() {
        return new DeliveryFragment();
    }

    private View view;
    private onClickButtonNext clickButtonNext;

    @Override
    public DeliveryInterface.Presenter createPresenter() {
        return DeliveryPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_delivery;
    }

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
    public void bindView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void setupInstance() {

    }

    @Override
    public void setupView() {
        imageDelivery.setVisibility(View.GONE);
        radioMassenger.setOnClickListener( OptionDeliveryOnClickListener );
        radioEMS.setOnClickListener( OptionDeliveryOnClickListener );
        radioAddress.setOnClickListener( OptionOnClickListener );
        radioAdd.setOnClickListener( OptionOnClickListener );
        buttonNext.setOnClickListener( onNext() );
    }

    @Override
    public void initialize() {

    }

    RadioButton.OnClickListener OptionOnClickListener = new RadioButton.OnClickListener() {
        public void onClick(View v) {
            if (radioAddress.isChecked()) {
                existAddress.setVisibility(View.VISIBLE);
                insertAddress.setVisibility(View.GONE);
                viewCurrentAddress();
            } else {
                radioAddress.setChecked(false);
                existAddress.setVisibility(View.GONE);
                insertAddress.setVisibility(View.VISIBLE);
                viewInsertAddress();
                getPresenter().onLoadProvince();
            }
        }
    };

    RadioButton.OnClickListener OptionDeliveryOnClickListener = new RadioButton.OnClickListener() {
        public void onClick(View v) {
            if (radioMassenger.isChecked()) {
                deliveryBy = "Massenger";
                imageDelivery.setVisibility(View.VISIBLE);
                imageDelivery.setImageDrawable(getResources().getDrawable(R.drawable.kerry));
            } else {
                deliveryBy = "EMS";
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
                //Log.e("Test", districtSpinner.getText().toString());
                clickButtonNext.OnClickButtonNext(view);
            }
        };
    }

    @Override
    public void setProvince(final List<ThailandItem> thailandItemList) {
        spinnerCustomAdapter = new SpinnerCustomAdapter(getActivity(), R.layout.spinner_item, thailandItemList, getResources(), "province");


        provinceSpinner.setAdapter(spinnerCustomAdapter);
        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position > 0) {
                    ((TextView) view.findViewById(R.id.row_item)).setTextColor(getResources().getColor(R.color.Black));
                    /*DataItem item = dataItemList.get(position);
                    province = item.getDataId();
                    getPresenter().requestDistrict(Config.KEY_DISTRICT, item.getDataCode());*/
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void setDistrict(final List<ThailandItem> thailandItemList) {
        spinnerCustomAdapter = new SpinnerCustomAdapter(getActivity(), R.layout.spinner_item, thailandItemList, getResources(), "province");


        districtSpinner.setAdapter(spinnerCustomAdapter);
        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position > 0) {
                    ((TextView) view.findViewById(R.id.row_item)).setTextColor(getResources().getColor(R.color.Black));
                    /*DataItem item = dataItemList.get(position);
                    province = item.getDataId();
                    getPresenter().requestDistrict(Config.KEY_DISTRICT, item.getDataCode());*/
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void setSubDistrict(List<ThailandItem> thailandItemList) {
        spinnerCustomAdapter = new SpinnerCustomAdapter(getActivity(), R.layout.spinner_item, thailandItemList, getResources(), "province");


        sub_districtSpinner.setAdapter(spinnerCustomAdapter);
        sub_districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position > 0) {
                    ((TextView) view.findViewById(R.id.row_item)).setTextColor(getResources().getColor(R.color.Black));
                    /*DataItem item = dataItemList.get(position);
                    province = item.getDataId();
                    getPresenter().requestDistrict(Config.KEY_DISTRICT, item.getDataCode());*/
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public interface onClickButtonNext{
        void OnClickButtonNext(View view);
    }

    private TextView textViewSummary;
    private void viewCurrentAddress() {
        textViewSummary = (TextView) existAddress.findViewById(R.id.textViewSum);
        StringBuilder sb = new StringBuilder();
        sb.append("\t" + getActivity().getResources().getString(R.string.address_name) + ": " + "\n\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_phone) + ": " + "\n\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_number) + ": " + "\n\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_building) + ": " + "\n\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_village) + ":" + "\n\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_soi) + ":" + "\n\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_road) + ": " + "\n\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_sub_district) + ": " + "\n\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_district) + ": " + "\n\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_province) + ": " + "\n\n");
        sb.append("\t" + getActivity().getResources().getString(R.string.address_zipcode) + ": ");
        textViewSummary.setText(sb.toString());
    }

    private void viewInsertAddress() {
        provinceSpinner = (Spinner) insertAddress.findViewById(R.id.province_spinner);
        districtSpinner = (Spinner) insertAddress.findViewById(R.id.district_spinner);
        sub_districtSpinner = (Spinner) insertAddress.findViewById(R.id.sub_district_spinner);
    }
}
