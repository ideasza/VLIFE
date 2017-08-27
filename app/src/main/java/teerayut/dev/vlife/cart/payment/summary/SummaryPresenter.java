package teerayut.dev.vlife.cart.payment.summary;

import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public class SummaryPresenter extends BaseMvpPresenter<SummaryInterface.View> implements SummaryInterface.Presenter {

    public static SummaryInterface.Presenter create() {
        return new SummaryPresenter();
    }

    @Override
    public void sendOrder() {
        getView().onSuccess("");
    }
}
