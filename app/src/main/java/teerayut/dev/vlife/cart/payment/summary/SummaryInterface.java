package teerayut.dev.vlife.cart.payment.summary;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public class SummaryInterface {

    public interface View extends BaseMvpInterface.View {
        void onFail(String failed);
        void onSuccess(String success);
        void onGoToHomePage();
    }

    public interface Presenter extends BaseMvpInterface.Presenter<SummaryInterface.View> {
        void sendOrder();
    }
}
