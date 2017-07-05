package teerayut.dev.vlife.authentication;

import teerayut.dev.vlife.base.BaseMvpInterface;
import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by teerayut.k on 7/5/2017.
 */

public class AuthenticationPresenter extends BaseMvpPresenter<AuthenticationInterface.View>
        implements AuthenticationInterface.Presenter {

    public static AuthenticationInterface.Presenter create() {
        return new AuthenticationPresenter();
    }
}
