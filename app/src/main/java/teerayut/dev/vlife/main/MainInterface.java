package teerayut.dev.vlife.main;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by OzoeSK on 7/5/2017.
 */

public class MainInterface {

    public interface View extends BaseMvpInterface.View {

    }

    public interface Presenter extends BaseMvpInterface.Presenter<MainInterface.View> {

    }
}
