package teerayut.dev.vlife.payment.detail;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
    @BindView(R.id.button_detail_next) Button buttonNext;
    private void bindView(View view) {
        ButterKnife.bind(this, view);
        buttonNext.setOnClickListener( onNext() );
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
