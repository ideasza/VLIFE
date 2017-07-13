package teerayut.dev.vlife.authentication;

import android.content.Context;

import teerayut.dev.vlife.R;

/**
 * Created by teerayut.k on 7/13/2017.
 */

public class AuthenticationPresenter implements AuthenticationInterface.Presenter{

    private AuthenticationInterface.View view;
    public AuthenticationPresenter(AuthenticationInterface.View view) {
        this.view = view;
    }

    @Override
    public void authen(Context context, String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            view.onFail(context.getResources().getString(R.string.dialog_msg_login_empty));
        } else {
            if (!username.equals("0000018") && !password.equals("1234")) {
                view.onFail(context.getResources().getString(R.string.dialog_msg_login_fail));
            } else {
                view.onSuccess();
            }
        }
    }

    @Override
    public void forget() {
        view.onGoToForget();
    }

    @Override
    public void register() {
        view.onGoToSignUP();
    }
}
