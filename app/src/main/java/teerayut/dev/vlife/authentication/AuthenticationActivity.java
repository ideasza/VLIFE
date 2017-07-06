package teerayut.dev.vlife.authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpActivity;
import teerayut.dev.vlife.utils.Config;

public class AuthenticationActivity extends BaseMvpActivity<AuthenticationInterface.Presenter> implements AuthenticationInterface.View {


    @Override
    public AuthenticationInterface.Presenter createPresenter() {
        return AuthenticationPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_authentication;
    }

    @BindView(R.id.button_language) Button buttonLanguage;
    @BindView(R.id.user_name) EditText userName;
    @BindView(R.id.user_pwd) EditText passWord;
    @BindView(R.id.button_sign_in) Button buttonLogin;
    @BindView(R.id.remember) CheckBox rememberMe;
    @BindView(R.id.forgetpassword) TextView forgetPassword;
    @BindView(R.id.register) TextView buttonRegister;
    @Override
    public void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    public void setupInstance() {

    }

    @Override
    public void setupView() {
        buttonLanguage.setOnClickListener( onLanguageChange() );
        buttonLogin.setOnClickListener( onLogIn() );
        forgetPassword.setOnClickListener( onForget() );
        buttonRegister.setOnClickListener( onSignUP() );
    }

    @Override
    public void initialize() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Config.REQUEST_SETTINGS) {

        }
    }

    private View.OnClickListener onLogIn() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }

    private View.OnClickListener onForget() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }

    private View.OnClickListener onSignUP() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }

    private View.OnClickListener onLanguageChange() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }
}
