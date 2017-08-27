package teerayut.dev.vlife.home;

import java.util.List;

import teerayut.dev.vlife.base.BaseMvpInterface;
import teerayut.dev.vlife.home.Item.ProductItem;

/**
 * Created by teerayut.k on 7/9/2017.
 */

public class HomeInterface {

    public interface View extends BaseMvpInterface.View {
        void setItemToRecyclerView(List<ProductItem> modelList);
        void showUnvailable();
        void showAvailable();
    }

    public interface Presenter extends BaseMvpInterface.Presenter<HomeInterface.View> {
        void requestItem();
    }
}
