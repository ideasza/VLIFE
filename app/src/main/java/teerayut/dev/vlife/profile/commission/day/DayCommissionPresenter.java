package teerayut.dev.vlife.profile.commission.day;

/**
 * Created by teerayut.k on 7/31/2017.
 */

public class DayCommissionPresenter implements DayCommissionInterface.Presenter {

    private DayCommissionInterface.View view;
    public DayCommissionPresenter(DayCommissionInterface.View view) {
        this.view = view;
    }

    @Override
    public void requestDayCommission() {

    }
}
