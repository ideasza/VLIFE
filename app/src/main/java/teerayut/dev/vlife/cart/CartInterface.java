package teerayut.dev.vlife.cart;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by teerayut.k on 7/11/2017.
 */

public class CartInterface {

    public interface View extends BaseMvpInterface.View {
    }

    public interface Presenter extends BaseMvpInterface.Presenter<CartInterface.View> {

    }
}
