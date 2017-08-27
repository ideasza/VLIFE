package teerayut.dev.vlife.forgetpassword;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpActivity;
import teerayut.dev.vlife.utils.Alert;

public class ForgetActivity extends BaseMvpActivity<ForgetInterface.Presenter> implements ForgetInterface.View {

    @Override
    public ForgetInterface.Presenter createPresenter() {
        return ForgetPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_forget;
    }

    @BindView(R.id.forget_input) EditText input_email;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @Override
    public void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    public void setupInstance() {

    }

    @Override
    public void setupView() {
        setToolbar();
        resetPassword();
    }

    @Override
    public void initialize() {

    }

    private void setToolbar() {
        toolbar.setTitle(getResources().getString(R.string.forgetpassword));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void resetPassword() {
        input_email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(input_email.getWindowToken(), 0);
                    getPresenter().onResetPassword(input_email.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            setResult(RESULT_CANCELED);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLoad() {
        Alert.dialogLoading(ForgetActivity.this);
    }

    @Override
    public void onDismiss() {
        Alert.dialogDimiss();
    }

    @Override
    public void onSuccess() {
        Alert.dialogSuccess(ForgetActivity.this, R.string.dialog_msg_sent_email_success, null);
    }

    @Override
    public void onFail(String fail) {
        if (fail.equals("empty")) {
            Alert.dialogError(ForgetActivity.this, R.string.dialog_msg_email_empty);
        } else {
            Alert.dialogError(ForgetActivity.this, R.string.dialog_msg_no_email_register);
        }
    }
}
