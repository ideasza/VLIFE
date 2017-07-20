package teerayut.dev.vlife.cart.payment;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public interface PaymentInterface {

    public interface View {
        void onNextViewPager(int number);
        void onGoToSummaryPage();
    }

    public interface Presenter {
        void nextViewPager(int currentPage);
        void GoToSummaryPage();
    }
}

