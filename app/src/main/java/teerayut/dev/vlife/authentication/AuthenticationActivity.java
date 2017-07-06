package teerayut.dev.vlife.authentication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpActivity;
import teerayut.dev.vlife.utils.Config;
import teerayut.dev.vlife.utils.LanguageHelper;
import teerayut.dev.vlife.utils.MyApplication;

public class AuthenticationActivity extends BaseMvpActivity<AuthenticationInterface.Presenter> implements AuthenticationInterface.View {

    private String DEFUALT_LANGUAGE;

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
        activeEvent();
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            loadLanguageSettings();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Config.KEY_LANGUAGE, MyApplication.getInstance().getPrefManager().getPreferrence(Config.KEY_LANGUAGE));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getString(Config.KEY_LANGUAGE).equals("en")) {
            setButtonTH();
            LanguageHelper.changeLocale(this.getResources(), savedInstanceState.getString(Config.KEY_LANGUAGE));
            MyApplication.getInstance().getPrefManager().setPreferrence(Config.KEY_LANGUAGE, savedInstanceState.getString(Config.KEY_LANGUAGE));
            reload();
        } else {
            setButtonEN();
            LanguageHelper.changeLocale(this.getResources(), savedInstanceState.getString(Config.KEY_LANGUAGE));
            MyApplication.getInstance().getPrefManager().setPreferrence(Config.KEY_LANGUAGE, savedInstanceState.getString(Config.KEY_LANGUAGE));
            reload();
        }
        Log.e("Restore language ",  savedInstanceState.getString(Config.KEY_LANGUAGE));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Config.REQUEST_SETTINGS) {

        }
    }

    private void activeEvent() {
        userName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    passWord.requestFocus();
                    return true;
                }
                return false;
            }
        });

        passWord.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(passWord.getWindowToken(), 0);
                    buttonLogin.performClick();
                    return true;
                }
                return false;
            }
        });
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
                changeButtonLanguage(view);
            }
        };
    }

    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        startActivity(intent);
    }

    private void setButtonTH() {
        buttonLanguage.setText("TH");
        buttonLanguage.setTextColor(getApplication().getResources().getColor(R.color.colorPrimaryDark));
        buttonLanguage.setBackgroundResource(R.drawable.circle_shape);
        buttonLanguage.setTag(0);
    }

    private void setButtonEN() {
        buttonLanguage.setText("EN");
        buttonLanguage.setTextColor(getApplication().getResources().getColor(R.color.White));
        buttonLanguage.setBackgroundResource(R.drawable.border_shape);
        buttonLanguage.setTag(1);
    }

    private void initDefualtLanguage() {
        DEFUALT_LANGUAGE = Locale.getDefault().getDisplayLanguage();
        if (DEFUALT_LANGUAGE.equals("ไทย")) {
            setButtonEN();
            MyApplication.getInstance().getPrefManager().setPreferrence(Config.KEY_LANGUAGE, "th");
        } else if (DEFUALT_LANGUAGE.equals("English")) {
            setButtonTH();
            MyApplication.getInstance().getPrefManager().setPreferrence(Config.KEY_LANGUAGE, "en");
        }
    }

    private void loadLanguageSettings() {
        try {
            if (MyApplication.getInstance().getPrefManager().getPreferrence(Config.KEY_LANGUAGE).equals("th")) {
                setButtonEN();
                LanguageHelper.changeLocale(getBaseContext().getResources(), MyApplication.getInstance().getPrefManager().getPreferrence(Config.KEY_LANGUAGE));
                Log.e("Languages ", MyApplication.getInstance().getPrefManager().getPreferrence(Config.KEY_LANGUAGE));
            } else if (MyApplication.getInstance().getPrefManager().getPreferrence(Config.KEY_LANGUAGE).equals("en")) {
                setButtonTH();
                LanguageHelper.changeLocale(getBaseContext().getResources(),MyApplication.getInstance().getPrefManager().getPreferrence(Config.KEY_LANGUAGE));
                Log.e("Languages ", MyApplication.getInstance().getPrefManager().getPreferrence(Config.KEY_LANGUAGE));
            }
        } catch (Exception ex) {
            Log.e(this.getClass().getSimpleName(), "Get settings : " + ex.toString());
            initDefualtLanguage();
        }
    }

    private void changeButtonLanguage(View v) {
        final int status = (Integer) v.getTag();
        switch (status) {
            case 0 :
                setButtonEN();
                LanguageHelper.changeLocale(this.getResources(), "th");
                MyApplication.getInstance().getPrefManager().setPreferrence(Config.KEY_LANGUAGE, "th");
                reload();
                break;
            case 1 :
                setButtonTH();
                LanguageHelper.changeLocale(this.getResources(), "en");
                MyApplication.getInstance().getPrefManager().setPreferrence(Config.KEY_LANGUAGE, "en");
                reload();
                break;
            default: break;
        }
    }
}
