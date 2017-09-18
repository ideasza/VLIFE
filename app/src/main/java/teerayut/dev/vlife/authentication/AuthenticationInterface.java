package teerayut.dev.vlife.authentication;

import android.content.Context;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by teerayut.k on 7/13/2017.
 */

public class AuthenticationInterface {

    public interface View extends BaseMvpInterface.View {
        void onFail(int fail);
        void onSuccess();
        void onGoToSignUP();
        void onGoToForget();
    }

    public interface Presenter extends BaseMvpInterface.Presenter<AuthenticationInterface.View> {
        void authen(String username, String password);
        void forget();
        void register();
    }
}
