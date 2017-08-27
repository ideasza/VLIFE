package teerayut.dev.vlife.register;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by teerayut.k on 7/15/2017.
 */

public class RegisterInterface {

    public interface View extends BaseMvpInterface.View {
        void onNextViewPager(int number);
    }

    public interface Presenter extends BaseMvpInterface.Presenter<RegisterInterface.View> {
        void nextViewPager(int currentPage);
    }
}
