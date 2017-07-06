package teerayut.dev.vlife.fragment.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseMvpFragment<NewsInterface.Presenter> implements NewsInterface.View {


    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public NewsInterface.Presenter createPresenter() {
        return NewsPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_news;
    }

    @Override
    public void bindView(View view) {

    }

    @Override
    public void setupInstance() {

    }

    @Override
    public void setupView() {

    }

    @Override
    public void initialize() {

    }

}
