package teerayut.dev.vlife.authentication;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by teerayut.k on 7/5/2017.
 */

public class AuthenticationInterface {

    public interface View extends BaseMvpInterface.View {

    }

    public interface Presenter extends BaseMvpInterface.Presenter<AuthenticationInterface.View> {

    }
}
