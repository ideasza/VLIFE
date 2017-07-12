package teerayut.dev.vlife.home;

import java.util.List;

import teerayut.dev.vlife.home.Item.ProductItem;

/**
 * Created by teerayut.k on 7/9/2017.
 */

public interface HomeInterface {

    interface View {
        void setItemToRecyclerView(List<ProductItem> modelList);
        void showUnvailable();
        void showAvailable();
    }

    interface Presenter {
        void requestItem();
    }
}
