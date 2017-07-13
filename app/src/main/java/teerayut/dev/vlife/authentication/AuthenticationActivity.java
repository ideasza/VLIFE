package teerayut.dev.vlife.authentication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.forgetpassword.ForgetActivity;
import teerayut.dev.vlife.register.RegisterActivity;
import teerayut.dev.vlife.utils.Alert;
import teerayut.dev.vlife.utils.AnimateButton;
import teerayut.dev.vlife.utils.Config;
import teerayut.dev.vlife.utils.MyApplication;

public class AuthenticationActivity extends AppCompatActivity implements AuthenticationInterface.View{

    private AuthenticationInterface.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        bindView();
    }

    @BindView(R.id.forgetpassword) TextView forget;
    @BindView(R.id.remember) CheckBox checkBox;
    @BindView(R.id.register) TextView regisTer;
    @BindView(R.id.user_name) EditText userName;
    @BindView(R.id.user_pwd) EditText userPassword;
    @BindView(R.id.button_sign_in) Button login;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private void bindView() {
        ButterKnife.bind(this);
        setToolbar();
        setInstance();
        login.setOnClickListener( onLogin() );
        regisTer.setOnClickListener( onRegister() );
        checkBox.setOnClickListener( onRemember() );
        forget.setOnClickListener( onForget() );
    }

    private void setToolbar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setInstance() {
        presenter = new AuthenticationPresenter(this);
        checkRemember();

        userName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    userPassword.requestFocus();
                    return true;
                }
                return false;
            }
        });

        userPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(userPassword.getWindowToken(), 0);
                    login.performClick();
                    return true;
                }
                return false;
            }
        });
    }

    private void checkRemember() {
        try {
            if (MyApplication.getInstance().getPrefManager().getPreferrenceBoolean(Config.KEY_REMEMBER)) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }
        } catch (Exception e) {
            checkBox.setChecked(false);
        }
    }

    @Override
    public void onFail(String fail) {
        Alert.dialogError(AuthenticationActivity.this, R.string.dialog_msg_login_fail);
    }

    @Override
    public void onSuccess() {
        MyApplication.getInstance().getPrefManager().setPreferrenceBoolean(Config.KEY_SESSION_LOGIN, true);
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onGoToSignUP() {
        startActivityForResult(new Intent(getApplicationContext(), RegisterActivity.class), Config.REQUEST_REGISTER);
    }

    @Override
    public void onGoToForget() {
        startActivityForResult(new Intent(getApplicationContext(), ForgetActivity.class), Config.REQUEST_FORGET);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            setResult(RESULT_CANCELED);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener onLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.authen(AuthenticationActivity.this, userName.getText().toString(), userPassword.getText().toString());
            }
        };
    }

    private View.OnClickListener onRegister() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regisTer.startAnimation(new AnimateButton().animbutton());
                presenter.register();
            }
        };
    }

    private View.OnClickListener onRemember() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox.startAnimation(new AnimateButton().animbutton());
                if (checkBox.isChecked()) {
                    MyApplication.getInstance().getPrefManager().setPreferrenceBoolean(Config.KEY_REMEMBER, true);
                } else {
                    MyApplication.getInstance().getPrefManager().setPreferrenceBoolean(Config.KEY_REMEMBER, false);
                }
            }
        };
    }

    private View.OnClickListener onForget() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forget.startAnimation(new AnimateButton().animbutton());
                presenter.forget();
            }
        };
    }
}
