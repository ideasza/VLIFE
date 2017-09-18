package teerayut.dev.vlife.home;

import com.hwangjr.rxbus.RxBus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.api.ConvertItem;
import teerayut.dev.vlife.api.ServiceManager;
import teerayut.dev.vlife.api.result.ProductItemResultGroup;
import teerayut.dev.vlife.base.BaseMvpPresenter;
import teerayut.dev.vlife.home.Item.ProductItem;
import teerayut.dev.vlife.home.Item.ProductItemGroup;
import teerayut.dev.vlife.utils.Config;

/**
 * Created by teerayut.k on 7/9/2017.
 */

public class HomePresenter extends BaseMvpPresenter<HomeInterface.View> implements HomeInterface.Presenter {

    private ServiceManager serviceManager;
    private ProductItem itemModel;
    private ProductItemGroup itemGroup;
    private List<ProductItem> itemModelList = new ArrayList<ProductItem>();

    public static HomeInterface.Presenter create() {
        return new HomePresenter();
    }

    public HomePresenter() {
        serviceManager = ServiceManager.getInstance();
    }

    public void setManager( ServiceManager manager ){
        serviceManager = manager;
    }

    @Override
    public void onViewCreate() {
        RxBus.get().register( this );
    }

    @Override
    public void onViewDestroy() {
        RxBus.get().unregister( this );
    }

    @Override
    public void requestItem(String token) {
        getView().onLoad();
        serviceManager.requestProduct(token, new ServiceManager.ServiceManagerCallback<ProductItemResultGroup>() {
            @Override
            public void onSuccess(ProductItemResultGroup result) {
                getView().onDismiss();
                ProductItemGroup productItemGroup = ConvertItem.createProductItemGroupFromResult(result);
                itemGroup = productItemGroup;
                setProductItemGroup(itemGroup);
                itemModelList = ConvertItem.createListProductItemFromResultGroup(result.getPRODUCT());
                getView().setItemToRecyclerView(itemModelList);
            }

            @Override
            public void onFailure(Throwable t) {
                getView().onDismiss();
                getView().onFail(t.getMessage());
            }
        });
    }

    @Override
    public void setProductItemGroup(ProductItemGroup group) {
        this.itemGroup = group;
    }

    @Override
    public ProductItemGroup getProductItemGroup() {
        return itemGroup;
    }

    @Override
    public void setProductItemToAdapter(ProductItemGroup group) {
        itemModelList = group.getPRODUCT();
        getView().setItemToRecyclerView(itemModelList);
    }
}
