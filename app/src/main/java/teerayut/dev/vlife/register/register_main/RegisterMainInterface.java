package teerayut.dev.vlife.register.register_main;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by teerayut.k on 9/18/2017.
 */

public class RegisterMainInterface {

    public interface View extends BaseMvpInterface.View {
        void onLoad();
        void onDismiss();
        void onSuccess();
        void onFail();
        void setRecommendName(String name);
        void setUplineName(String name);
    }

    public interface Presenter extends BaseMvpInterface.Presenter<RegisterMainInterface.View> {
        void searchRecommendByCode(String code);
        void searchUplineByCode(String code);
    }
}
