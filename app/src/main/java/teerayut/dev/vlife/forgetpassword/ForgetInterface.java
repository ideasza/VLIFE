package teerayut.dev.vlife.forgetpassword;

/**
 * Created by teerayut.k on 7/23/2017.
 */

public interface ForgetInterface {

    public interface View {
        void onLoad();
        void onDismiss();
        void onSuccess();
        void onFail(String fail);
    }

    public interface Presenter {
        void onResetPassword(String email);
    }
}
