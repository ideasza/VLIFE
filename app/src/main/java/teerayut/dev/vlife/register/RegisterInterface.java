package teerayut.dev.vlife.register;

/**
 * Created by teerayut.k on 7/15/2017.
 */

public interface RegisterInterface {

    public interface View {
        void onNextViewPager(int number);
    }

    public interface Presenter {
        void nextViewPager(int currentPage);
    }
}
