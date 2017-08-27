package teerayut.dev.vlife.authentication;

import android.content.Context;

import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by teerayut.k on 7/13/2017.
 */

public class AuthenticationPresenter extends BaseMvpPresenter<AuthenticationInterface.View> implements AuthenticationInterface.Presenter{

    public static AuthenticationInterface.Presenter create() {
        return new AuthenticationPresenter();
    }

    @Override
    public void authen(Context context, String username, String password) {
        if (username.equals("") || password.equals("")) {
            getView().onFail(context.getResources().getString(R.string.dialog_msg_login_empty));
        } else {
            if (!username.equals("0000018") && !password.equals("1234")) {
                getView().onFail(context.getResources().getString(R.string.dialog_msg_login_fail));
            } else {
                getView().onSuccess();
            }
        }
    }

    @Override
    public void forget() {
        getView().onGoToForget();
    }

    @Override
    public void register() {
        getView().onGoToSignUP();
    }
}
