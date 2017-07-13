package teerayut.dev.vlife.authentication;

import android.content.Context;

/**
 * Created by teerayut.k on 7/13/2017.
 */

public interface AuthenticationInterface {

    public interface View {
        void onFail(String fail);
        void onSuccess();
        void onGoToSignUP();
        void onGoToForget();
    }

    public interface Presenter {
        void authen(Context context, String username, String password);
        void forget();
        void register();
    }
}
