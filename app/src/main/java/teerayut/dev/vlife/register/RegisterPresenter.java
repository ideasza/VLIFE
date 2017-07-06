package teerayut.dev.vlife.register;

import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by OzoeSK on 7/6/2017.
 */

public class RegisterPresenter extends BaseMvpPresenter<RegisterInterface.View> implements RegisterInterface.Presenter {

    public static RegisterInterface.Presenter create() {
        return new RegisterPresenter();
    }
}
