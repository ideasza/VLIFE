package teerayut.dev.vlife.cart.payment.delivery;

import java.util.List;

import teerayut.dev.vlife.base.BaseMvpInterface;
import teerayut.dev.vlife.cart.payment.delivery.item.ThailandItem;

/**
 * Created by teerayut.k on 7/13/2017.
 */

public class DeliveryInterface {

    public interface View extends BaseMvpInterface.View {
        void setProvince(List<ThailandItem> thailandItemList);
        void setDistrict(List<ThailandItem> thailandItemList);
        void setSubDistrict(List<ThailandItem> thailandItemList);
    }

    public interface Presenter extends BaseMvpInterface.Presenter<DeliveryInterface.View> {
        void onLoadProvince();
        void onLoadDistrict(String id);
        void onLoadSubDistrict(String id);
    }
}
