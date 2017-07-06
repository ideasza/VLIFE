package teerayut.dev.vlife.fragment.firstpage;

import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.base.BaseMvpPresenter;
import teerayut.dev.vlife.fragment.firstpage.item.Item;
import teerayut.dev.vlife.utils.Config;

/**
 * Created by teerayut.k on 7/6/2017.
 */

public class HomeFragmentPresenter extends BaseMvpPresenter<HomeFragmentInterface.View> implements HomeFragmentInterface.Presenter {

    private Item item;
    private List<Item> itemList = new ArrayList<Item>();

    public static HomeFragmentInterface.Presenter create() {
        return new HomeFragmentPresenter();
    }

    @Override
    public void requestProduct() {

        item = new Item()
                .setId("0001")
                .setName("I-SLYM")
                .setPv(250)
                .setPrice(1200)
                .setImage(Config.PRODUCT_URL_1);
        itemList.add(item);

        item = new Item()
                .setId("0002")
                .setName("SYOSS")
                .setPv(50)
                .setPrice(250)
                .setImage(Config.PRODUCT_URL_2);
        itemList.add(item);

        item = new Item()
                .setId("0003")
                .setName("LIEVE")
                .setPv(200)
                .setPrice(600)
                .setImage(Config.PRODUCT_URL_3);
        itemList.add(item);

        item = new Item()
                .setId("0004")
                .setName("VITRA")
                .setPv(150)
                .setPrice(300)
                .setImage(Config.PRODUCT_URL_4);
        itemList.add(item);

        item = new Item()
                .setId("0005")
                .setName("GARNIAR")
                .setPv(120)
                .setPrice(500)
                .setImage(Config.PRODUCT_URL_5);
        itemList.add(item);

        item = new Item()
                .setId("0006")
                .setName("LE'SKIN MILK")
                .setPv(50)
                .setPrice(390)
                .setImage(Config.PRODUCT_URL_6);
        itemList.add(item);

        item = new Item()
                .setId("0007")
                .setName("FG PASTEL")
                .setPv(100)
                .setPrice(500)
                .setImage(Config.PRODUCT_URL_7);
        itemList.add(item);

        getView().setProductList(itemList);
    }
}
