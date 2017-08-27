package teerayut.dev.vlife.cart.payment;

import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public class PaymentPresenter extends BaseMvpPresenter<PaymentInterface.View> implements PaymentInterface.Presenter {

    public static PaymentInterface.Presenter create() {
        return new PaymentPresenter();
    }

    @Override
    public void nextViewPager(int currenctPage) {
        getView().onNextViewPager(currenctPage + 1);
    }

    @Override
    public void GoToSummaryPage() {
        getView().onGoToSummaryPage();
    }
}
