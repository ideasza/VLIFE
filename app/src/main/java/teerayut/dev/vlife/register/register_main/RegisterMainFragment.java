package teerayut.dev.vlife.register.register_main;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.fourmob.datetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpFragment;
import teerayut.dev.vlife.utils.Alert;
import teerayut.dev.vlife.utils.AnimateButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterMainFragment extends BaseMvpFragment<RegisterMainInterface.Presenter> implements RegisterMainInterface.View {

    private String side;
    private String gender;
    private int currentYear;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;

    public static RegisterMainFragment newInstance(){
        return new RegisterMainFragment();
    }

    public RegisterMainFragment() {
        // Required empty public constructor
    }

    private onClickButtonNext clickButtonNext;

    @Override
    public RegisterMainInterface.Presenter createPresenter() {
        return RegisterMainPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_register_main;
    }

    @BindView(R.id.recomend_code) EditText recomendCode;
    @BindView(R.id.recomend_name) EditText recomendName;
    @BindView(R.id.recomend_search) ImageView recomendSearch;
    @BindView(R.id.upline_code) EditText uplineCode;
    @BindView(R.id.upline_name) EditText uplineName;
    @BindView(R.id.upline_search) ImageView uplineSearch;
    @BindView(R.id.type_spinner) Spinner typeSpinner;
    @BindView(R.id.radio_left) RadioButton radioButtonLeft;
    @BindView(R.id.radio_right) RadioButton radioButtonRight;
    @BindView(R.id.prefix_spinner) Spinner prefixSpinner;
    @BindView(R.id.register_name) EditText registerName;
    @BindView(R.id.radio_male) RadioButton radioButtonMale;
    @BindView(R.id.radio_female) RadioButton radioButtonFemale;
    @BindView(R.id.birth_date) EditText birthDate;
    @BindView(R.id.datePicker) ImageView datePicker;
    @BindView(R.id.nationality_spinner) Spinner nationalitySpinner;
    @BindView(R.id.register_idcard) EditText registerID;
    @BindView(R.id.register_phone) EditText registerPhone;
    @BindView(R.id.register_mobile) EditText registerMobile;
    @BindView(R.id.register_email) EditText registerEmail;
    @BindView(R.id.register_line_id) EditText registerLineID;
    @BindView(R.id.register_facebook) EditText registerFB;
    @BindView(R.id.register_we_chat) EditText registerWC;
    @BindView(R.id.button_main_next) Button buttonNext;
    @Override
    public void bindView(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void setupInstance() {
        calendar = Calendar.getInstance();
    }

    @Override
    public void setupView() {
        recomendName.setEnabled(false);
        uplineName.setEnabled(false);
        recomendSearch.setOnClickListener( onRecomendSearch() );
        uplineSearch.setOnClickListener( onUplineSearch() );
        datePicker.setOnClickListener( onDatePicker() );
        radioButtonLeft.setOnClickListener( optionSideListener );
        radioButtonRight.setOnClickListener( optionSideListener );
        radioButtonMale.setOnClickListener( optionGenderListener );
        radioButtonFemale.setOnClickListener( optionGenderListener );
        buttonNext.setOnClickListener( onNext() );
    }

    @Override
    public void initialize() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            clickButtonNext = (onClickButtonNext) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(((Activity) context).getLocalClassName()
                    + " RegisterMainFragment implement OnButtonClickListener");
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

    @Override
    public void onLoad() {
        Alert.dialogLoading(getActivity());
    }

    @Override
    public void onDismiss() {
        Alert.dialogDimiss();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFail() {
        Alert.dialogError(getActivity(), 0);
    }

    public interface onClickButtonNext{
        void OnClickButtonNext(View view);
    }

    private View.OnClickListener onRecomendSearch() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recomendSearch.startAnimation(new AnimateButton().animbutton());
                getPresenter().searchRecommendByCode(recomendCode.getText().toString());
            }
        };
    }

    private View.OnClickListener onUplineSearch() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uplineSearch.startAnimation(new AnimateButton().animbutton());
                getPresenter().searchUplineByCode(uplineCode.getText().toString());
            }
        };
    }

    private View.OnClickListener onDatePicker() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.startAnimation(new AnimateButton().animbutton());
                initCalendar();
                datePickerDialog.setYearRange(1970, 2000);
                datePickerDialog.show(getFragmentManager(), "datePicker");
            }
        };
    }

    RadioButton.OnClickListener optionSideListener = new RadioButton.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (radioButtonLeft.isChecked()) {
                side = "";
            } else {
                side = "";
            }
        }
    };

    RadioButton.OnClickListener optionGenderListener = new RadioButton.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (radioButtonMale.isChecked()) {
                gender = "";
            } else {
                gender = "";
            }
        }
    };

    @Override
    public void setRecommendName(String name) {
        recomendName.setText(name);
    }

    @Override
    public void setUplineName(String name) {
        uplineName.setText(name);
    }

    private void initCalendar() {
        currentYear = Calendar.YEAR;
        datePickerDialog = DatePickerDialog.newInstance(onDateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                false);
    }

    private DatePickerDialog.OnDateSetListener onDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
                    String myFormat = "yyyy-MM-dd";
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                    calendar.set(year, month, day);
                    Date date = calendar.getTime();
                    String textDate = sdf.format(date);
                    birthDate.setText(textDate);
                }
            };
}
