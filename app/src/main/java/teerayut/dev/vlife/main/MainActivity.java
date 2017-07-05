package teerayut.dev.vlife.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<MainInterface.Presenter> implements MainInterface.View {

    @Override
    public MainInterface.Presenter createPresenter() {
        return MainPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this);
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
