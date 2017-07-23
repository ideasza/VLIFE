package teerayut.dev.vlife.forgetpassword;

/**
 * Created by teerayut.k on 7/23/2017.
 */

public class ForgetPresenter implements ForgetInterface.Presenter {

    private ForgetInterface.View view;
    public ForgetPresenter(ForgetInterface.View view) {
        this.view = view;
    }
    @Override
    public void onResetPassword(String email) {
        view.onLoad();
        if (email.isEmpty()) {
            view.onDismiss();
            view.onFail("empty");
        } else {
            view.onDismiss();
            view.onSuccess();
        }
    }
}
