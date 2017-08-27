package teerayut.dev.vlife.forgetpassword;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by teerayut.k on 7/23/2017.
 */

public class ForgetInterface {

    public interface View extends BaseMvpInterface.View {
        void onLoad();
        void onDismiss();
        void onSuccess();
        void onFail(String fail);
    }

    public interface Presenter extends BaseMvpInterface.Presenter<ForgetInterface.View> {
        void onResetPassword(String email);
    }
}
