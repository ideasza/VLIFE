package teerayut.dev.vlife.home;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.home.Item.ProductItem;
import teerayut.dev.vlife.utils.Config;

/**
 * Created by teerayut.k on 7/9/2017.
 */

public class HomePresenter implements HomeInterface.Presenter {

    private HomeInterface.View view;

    private ProductItem itemModel;
    private List<ProductItem> itemModelList = new ArrayList<ProductItem>();

    public HomePresenter(HomeInterface.View view) {
        this.view = view;
    }

    @Override
    public void requestItem() {
        itemModelList.clear();

        itemModel = new ProductItem();
        itemModel.setId("0001");
        itemModel.setName("I-SLYM");
        itemModel.setPv("250");
        itemModel.setPrice(BigDecimal.valueOf(1200));
        itemModel.setImage(Config.PRODUCT_URL_1);
        itemModelList.add(itemModel);

        itemModel = new ProductItem();
        itemModel.setId("0002");
        itemModel.setName("SYOSS");
        itemModel.setPv("50");
        itemModel.setPrice(BigDecimal.valueOf(250));
        itemModel.setImage(Config.PRODUCT_URL_2);
        itemModelList.add(itemModel);

        itemModel = new ProductItem();
        itemModel.setId("0003");
        itemModel.setName("LIEVE");
        itemModel.setPv("200");
        itemModel.setPrice(BigDecimal.valueOf(600));
        itemModel.setImage(Config.PRODUCT_URL_3);
        itemModelList.add(itemModel);

        itemModel = new ProductItem();
        itemModel.setId("0004");
        itemModel.setName("VITRA");
        itemModel.setPv("150");
        itemModel.setPrice(BigDecimal.valueOf(300));
        itemModel.setImage(Config.PRODUCT_URL_4);
        itemModelList.add(itemModel);

        itemModel = new ProductItem();
        itemModel.setId("0005");
        itemModel.setName("GARNIAR");
        itemModel.setPv("120");
        itemModel.setPrice(BigDecimal.valueOf(500));
        itemModel.setImage(Config.PRODUCT_URL_5);
        itemModelList.add(itemModel);

        itemModel = new ProductItem();
        itemModel.setId("0006");
        itemModel.setName("LE'SKIN MILK");
        itemModel.setPv("50");
        itemModel.setPrice(BigDecimal.valueOf(390));
        itemModel.setImage(Config.PRODUCT_URL_6);
        itemModelList.add(itemModel);

        itemModel = new ProductItem();
        itemModel.setId("0007");
        itemModel.setName("FG PASTEL");
        itemModel.setPv("100");
        itemModel.setPrice(BigDecimal.valueOf(500));
        itemModel.setImage(Config.PRODUCT_URL_7);
        itemModelList.add(itemModel);

        view.setItemToRecyclerView(itemModelList);
    }
}
