package teerayut.dev.vlife.cart.payment;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public class PaymentInterface {

    public interface View extends BaseMvpInterface.View {
        void onNextViewPager(int number);
        void onGoToSummaryPage();
    }

    public interface Presenter extends BaseMvpInterface.Presenter<PaymentInterface.View> {
        void nextViewPager(int currentPage);
        void GoToSummaryPage();
    }
}

