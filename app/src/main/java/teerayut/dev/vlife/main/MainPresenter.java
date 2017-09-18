package teerayut.dev.vlife.main;

import android.util.Log;

import com.hwangjr.rxbus.RxBus;

import java.util.Calendar;

import teerayut.dev.vlife.api.ServiceManager;
import teerayut.dev.vlife.api.request.RequestAuth;
import teerayut.dev.vlife.base.BaseMvpPresenter;
import teerayut.dev.vlife.utils.Config;
import teerayut.dev.vlife.utils.MyApplication;

/**
 * Created by teerayut.k on 7/9/2017.
 */

public class MainPresenter extends BaseMvpPresenter<MainInterface.View> implements MainInterface.Presenter {

    private String accessToken;
    private ServiceManager serviceManager;
    public static MainInterface.Presenter create() {
        return new MainPresenter();
    }

    public MainPresenter(){
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
    public void getAccessToken() {
        serviceManager.requestToken(new ServiceManager.ServiceManagerCallback<RequestAuth>() {
            @Override
            public void onSuccess(RequestAuth result) {
                Log.e("Access Token", result.getAccess_token());
                //MyApplication.getInstance().getPrefManager().setPreferrence(Config.KEY_TOKEN, result.getAccess_token());
                //MyApplication.getInstance().getPrefManager().setPreferrence(Config.KEY_EXPIRE, result.getExpire());
                getView().setAccessToken(result.getAccess_token());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Access Token fail", t.getMessage());
            }
        });
    }

    @Override
    public void setAccessToken(String token) {
        this.accessToken = token;
    }

    @Override
    public String getToken() {
        return accessToken;
    }
}
