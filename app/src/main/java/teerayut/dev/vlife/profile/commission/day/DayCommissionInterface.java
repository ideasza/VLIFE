package teerayut.dev.vlife.profile.commission.day;

/**
 * Created by teerayut.k on 7/31/2017.
 */

public interface DayCommissionInterface {

    public interface View {
        void showUnvailable();
        void showAvailable();
    }

    public interface Presenter {
        void requestDayCommission();
    }
}
