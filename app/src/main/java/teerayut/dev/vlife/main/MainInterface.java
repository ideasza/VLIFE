package teerayut.dev.vlife.main;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by teerayut.k on 7/9/2017.
 */

public class MainInterface {

    public interface View extends BaseMvpInterface.View {
        void setAccessToken(String token);
        String getAccessToken();
    }

    public interface Presenter extends BaseMvpInterface.Presenter<MainInterface.View> {
        void getAccessToken();
        void setAccessToken(String token);
        String getToken();
    }
}
