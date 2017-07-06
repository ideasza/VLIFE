package teerayut.dev.vlife.main;

import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by OzoeSK on 7/5/2017.
 */

public class MainPresenter extends BaseMvpPresenter<MainInterface.View> implements MainInterface.Presenter {

    public static MainInterface.Presenter create() {
        return new MainPresenter();
    }
}
