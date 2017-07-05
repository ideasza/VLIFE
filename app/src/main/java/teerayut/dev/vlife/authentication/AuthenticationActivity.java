package teerayut.dev.vlife.authentication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpActivity;

public class AuthenticationActivity extends BaseMvpActivity<AuthenticationInterface.Presenter> implements AuthenticationInterface.View {


    @Override
    public AuthenticationInterface.Presenter createPresenter() {
        return AuthenticationPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_authentication;
    }

    @Override
    public void bindView() {

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
