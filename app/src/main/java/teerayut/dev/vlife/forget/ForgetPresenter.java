package teerayut.dev.vlife.forget;

import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by teerayut.k on 7/6/2017.
 */

public class ForgetPresenter extends BaseMvpPresenter<ForgetInterface.View> implements ForgetInterface.Presenter {

    public static ForgetInterface.Presenter create() {
        return new ForgetPresenter();
    }
}
