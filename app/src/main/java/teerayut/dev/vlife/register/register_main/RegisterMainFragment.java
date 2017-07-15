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

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterMainFragment extends Fragment {

    public static RegisterMainFragment newInstance(){
        return new RegisterMainFragment();
    }

    public RegisterMainFragment() {
        // Required empty public constructor
    }

    private View view;
    private onClickButtonNext clickButtonNext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_register_main, container, false);
        bindView();
        return view;
    }

    @BindView(R.id.button_main_next) Button buttonNext;
    private void bindView() {
        ButterKnife.bind(this, view);
        setView();
    }

    private void setView() {
        buttonNext.setOnClickListener( onNext() );
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

    public interface onClickButtonNext{
        void OnClickButtonNext(View view);
    }

}
