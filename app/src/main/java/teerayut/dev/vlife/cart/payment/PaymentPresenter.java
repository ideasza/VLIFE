package teerayut.dev.vlife.cart.payment;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public class PaymentPresenter implements PaymentInterface.Presenter {

    private PaymentInterface.View view;
    public PaymentPresenter(PaymentInterface.View view) {
        this.view = view;
    }

    @Override
    public void nextViewPager(int currenctPage) {
        view.onNextViewPager(currenctPage + 1);
    }

    @Override
    public void GoToSummaryPage() {
        view.onGoToSummaryPage();
    }
}
