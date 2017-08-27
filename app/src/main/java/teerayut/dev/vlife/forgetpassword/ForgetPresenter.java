package teerayut.dev.vlife.forgetpassword;

import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by teerayut.k on 7/23/2017.
 */

public class ForgetPresenter extends BaseMvpPresenter<ForgetInterface.View> implements ForgetInterface.Presenter {

    public static ForgetInterface.Presenter create() {
        return new ForgetPresenter();
    }

    @Override
    public void onResetPassword(String email) {
        getView().onLoad();
        if (email.isEmpty()) {
            getView().onDismiss();
            getView().onFail("empty");
        } else {
            getView().onDismiss();
            getView().onSuccess();
        }
    }
}
