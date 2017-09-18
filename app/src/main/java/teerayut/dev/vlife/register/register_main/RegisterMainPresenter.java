package teerayut.dev.vlife.register.register_main;

import com.hwangjr.rxbus.RxBus;

import teerayut.dev.vlife.api.ServiceManager;
import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by teerayut.k on 9/18/2017.
 */

public class RegisterMainPresenter extends BaseMvpPresenter<RegisterMainInterface.View> implements RegisterMainInterface.Presenter {

    private ServiceManager serviceManager;

    public static RegisterMainInterface.Presenter create() {
        return new RegisterMainPresenter();
    }

    public RegisterMainPresenter() {
        serviceManager = ServiceManager.getInstance();
    }

    public void setManager( ServiceManager manager ){
        serviceManager = manager;
    }

    @Override
    public void onViewCreate() {
        RxBus.get().register( this );
    }

    @Override
    public void onViewDestroy() {
        RxBus.get().unregister( this );
    }

    @Override
    public void searchRecommendByCode(String code) {

    }

    @Override
    public void searchUplineByCode(String code) {

    }
}
