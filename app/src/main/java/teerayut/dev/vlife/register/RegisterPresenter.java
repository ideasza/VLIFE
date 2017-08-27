package teerayut.dev.vlife.register;

import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by teerayut.k on 7/15/2017.
 */

public class RegisterPresenter extends BaseMvpPresenter<RegisterInterface.View> implements RegisterInterface.Presenter {

    public static RegisterInterface.Presenter create() {
        return new RegisterPresenter();
    }

    @Override
    public void nextViewPager(int currentPage) {
        getView().onNextViewPager(currentPage + 1);
    }
}
