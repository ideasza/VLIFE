package teerayut.dev.vlife.cart;

import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by teerayut.k on 7/11/2017.
 */

public class CartPresenter extends BaseMvpPresenter<CartInterface.View> implements CartInterface.Presenter {

    public static CartInterface.Presenter create() {
        return new CartPresenter();
    }
}
