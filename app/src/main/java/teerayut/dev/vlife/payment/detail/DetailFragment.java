package teerayut.dev.vlife.payment.detail;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        bindView(view);
        return view;
    }

    private onClickButtonNext clickButtonNext;
    @BindView(R.id.sumTitle) TextView textViewSumTitle;
    @BindView(R.id.sumValues) TextView textViewSumValus;
    @BindView(R.id.button_detail_next) Button buttonNext;
    private void bindView(View view) {
        ButterKnife.bind(this, view);
        setView();
        buttonNext.setOnClickListener( onNext() );
    }

    private void setView() {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        sb1.append(getResources().getString(R.string.title_sum_point) + "\n");
        sb1.append(getResources().getString(R.string.title_sum_total) + "\n");
        sb1.append(getResources().getString(R.string.title_send) + "\n");
        sb1.append(getResources().getString(R.string.title_net_price));
        textViewSumTitle.setText(sb1.toString());

        sb2.append("0" + "\n");
        sb2.append("0" + " " + getResources().getString(R.string.price_symbol) + "\n");
        sb2.append("0" + " " +  getResources().getString(R.string.price_symbol) +  "\n");
        sb2.append("0" + " " +  getResources().getString(R.string.price_symbol));
        textViewSumValus.setText(sb2.toString());
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
}
