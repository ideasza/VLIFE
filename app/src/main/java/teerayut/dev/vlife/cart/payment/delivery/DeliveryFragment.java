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
import android.widget.TextView;

import com.reginald.editspinner.EditSpinner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.cart.payment.delivery.item.ThailandItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryFragment extends Fragment implements DeliveryInterface.View {
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
    private EditSpinner sub_districtSpinner;
    private EditSpinner districtSpinner;
    private EditSpinner provinceSpinner;
    /**
     * End
     */

    public DeliveryFragment() {
        // Required empty public constructor
    }

    public static DeliveryFragment newInstance() {
        return new DeliveryFragment();
    }

    private View view;
    private DeliveryInterface.Presenter presenter;
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
        setInstance();
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
                presenter.onLoadProvince();
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

    private void setInstance() {
        presenter = new DeliveryPresenter(this);
    }

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
        ListAdapter adapter = new ArrayAdapter<ThailandItem>(getActivity(), android.R.layout.simple_spinner_dropdown_item, thailandItemList);
        provinceSpinner.setAdapter(adapter);

        provinceSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ThailandItem item = thailandItemList.get(position);
                presenter.onLoadDistrict(item.getId());
            }
        });
    }

    @Override
    public void setDistrict(final List<ThailandItem> thailandItemList) {
        ListAdapter adapter = new ArrayAdapter<ThailandItem>(getActivity(), android.R.layout.simple_spinner_dropdown_item, thailandItemList);
        districtSpinner.setAdapter(adapter);

        districtSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ThailandItem item = thailandItemList.get(position);
                presenter.onLoadSubDistrict(item.getId());
            }
        });
    }

    @Override
    public void setSubDistrict(List<ThailandItem> thailandItemList) {
        ListAdapter adapter = new ArrayAdapter<ThailandItem>(getActivity(), android.R.layout.simple_spinner_dropdown_item, thailandItemList);
        sub_districtSpinner.setAdapter(adapter);

        sub_districtSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
        provinceSpinner = (EditSpinner) insertAddress.findViewById(R.id.province_spinner);
        districtSpinner = (EditSpinner) insertAddress.findViewById(R.id.district_spinner);
        sub_districtSpinner = (EditSpinner) insertAddress.findViewById(R.id.sub_district_spinner);
    }
}
