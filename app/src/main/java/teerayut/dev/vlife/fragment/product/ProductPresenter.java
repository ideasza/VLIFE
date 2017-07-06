package teerayut.dev.vlife.fragment.product;

import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by OzoeSK on 7/6/2017.
 */

public class ProductPresenter extends BaseMvpPresenter<ProductInterface.View> implements ProductInterface.Presenter {

    public static ProductInterface.Presenter create() {
        return new ProductPresenter();
    }
}
