package teerayut.dev.vlife.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpActivity;

public class RegisterActivity extends BaseMvpActivity<RegisterInterface.Presenter> implements RegisterInterface.View{

    @Override
    public RegisterInterface.Presenter createPresenter() {
        return RegisterPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_register;
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
}
