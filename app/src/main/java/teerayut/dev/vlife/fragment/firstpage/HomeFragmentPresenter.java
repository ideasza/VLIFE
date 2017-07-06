package teerayut.dev.vlife.fragment.firstpage;

import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by teerayut.k on 7/6/2017.
 */

public class HomeFragmentPresenter extends BaseMvpPresenter<HomeFragmentInterface.View> implements HomeFragmentInterface.Presenter {

    public static HomeFragmentInterface.Presenter create() {
        return new HomeFragmentPresenter();
    }
}
