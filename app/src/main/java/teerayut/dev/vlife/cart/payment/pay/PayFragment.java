package teerayut.dev.vlife.cart.payment.pay;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayFragment extends Fragment {


    public PayFragment() {
        // Required empty public constructor
    }

    public static PayFragment newInstance() {
        return new PayFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay, container, false);
        bindView(view);
        return view;
    }

    private onClickButtonNext clickButtonNext;
    @BindView(R.id.bank_tranfer) View bankView;
    @BindView(R.id.credit_card) View creditView;
    @BindView(R.id.radio_bank_tranfer) RadioButton bankTranfer;
    @BindView(R.id.radio_credit) RadioButton creditCard;
    @BindView(R.id.button_pay_next) Button buttonNext;
    private void bindView(View view) {
        ButterKnife.bind(this, view);
        buttonNext.setOnClickListener( onNext() );
        bankTranfer.setOnClickListener( PaymentOnClickListener );
        creditCard.setOnClickListener( PaymentOnClickListener );
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
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            clickButtonNext = (onClickButtonNext) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(((Activity) context).getLocalClassName()
                    + " DetailFragment implement OnButtonClickListener");
        }
    }

    public interface onClickButtonNext{
        void OnClickButtonNext(View view);
    }

    RadioButton.OnClickListener PaymentOnClickListener = new RadioButton.OnClickListener() {
        public void onClick(View v) {
            if (bankTranfer.isChecked()) {
                bankView.setVisibility(View.VISIBLE);
                creditView.setVisibility(View.GONE);
                //viewCurrentAddress();
            } else {
                bankTranfer.setChecked(false);
                bankView.setVisibility(View.GONE);
                creditView.setVisibility(View.VISIBLE);
                //viewInsertAddress();
            }
        }
    };
}
