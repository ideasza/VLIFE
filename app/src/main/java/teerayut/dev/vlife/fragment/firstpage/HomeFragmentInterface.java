package teerayut.dev.vlife.fragment.firstpage;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by teerayut.k on 7/6/2017.
 */

public class HomeFragmentInterface {

    public interface View extends BaseMvpInterface.View {

    }

    public interface Presenter extends BaseMvpInterface.Presenter<HomeFragmentInterface.View> {

    }
}
