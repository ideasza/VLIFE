package teerayut.dev.vlife.cart.payment.summary;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public class SummaryPresenter implements SummaryInterface.Presenter {

    private SummaryInterface.View view;
    public SummaryPresenter(SummaryInterface.View view) {
        this.view = view;
    }

    @Override
    public void sendOrder() {
        view.onSuccess("");
    }
}
