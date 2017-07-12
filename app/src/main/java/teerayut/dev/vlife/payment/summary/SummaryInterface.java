package teerayut.dev.vlife.payment.summary;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public interface SummaryInterface {

    public interface View {
        void onFail(String failed);
        void onSuccess(String success);
        void onGoToHomePage();
    }

    public interface Presenter {
        void sendOrder();
    }
}
