package teerayut.dev.vlife.fragment.firstpage;

import java.util.List;

import teerayut.dev.vlife.base.BaseMvpInterface;
import teerayut.dev.vlife.fragment.firstpage.item.Item;

/**
 * Created by teerayut.k on 7/6/2017.
 */

public class HomeFragmentInterface {

    public interface View extends BaseMvpInterface.View {
        void setProductList(List<Item> itemList);
    }

    public interface Presenter extends BaseMvpInterface.Presenter<HomeFragmentInterface.View> {
        void requestProduct();
    }
}
