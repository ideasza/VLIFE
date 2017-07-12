package teerayut.dev.vlife.payment.summary;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.main.MainActivity;
import teerayut.dev.vlife.payment.pay.PayFragment;
import teerayut.dev.vlife.utils.Alert;

/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryFragment extends Fragment implements SummaryInterface.View{


    public static SummaryFragment newInstance() {
        return new SummaryFragment();
    }

    public SummaryFragment() {
        // Required empty public constructor
    }

    private SummaryInterface.Presenter presenter;
    @BindView(R.id.button_summary_apply) Button buttonApply;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        bindView(view);
        return view;
    }

    private void bindView(View view) {
        ButterKnife.bind(this, view);
        buttonApply.setOnClickListener( onApply() );

        setInstance();
    }

    private void setInstance() {
        presenter = new SummaryPresenter(this);
    }

    private View.OnClickListener onApply() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.sendOrder();
            }
        };
    }

    @Override
    public void onFail(String failed) {
        Alert.dialogError(getActivity(), R.string.dialog_msg_apply_error);
    }

    @Override
    public void onSuccess(String success) {
        Alert.dialogSuccess(getActivity(), R.string.dialog_msg_apply_success);
    }

    @Override
    public void onGoToHomePage() {
        startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }
}
