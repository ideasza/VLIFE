package teerayut.dev.vlife.register;

/**
 * Created by teerayut.k on 7/15/2017.
 */

public class RegisterPresenter implements RegisterInterface.Presenter {

    private RegisterInterface.View view;
    public RegisterPresenter(RegisterInterface.View view) {
        this.view = view;
    }

    @Override
    public void nextViewPager(int currentPage) {
        view.onNextViewPager(currentPage + 1);
    }
}
