package teerayut.dev.vlife.payment.delivery;

import java.util.List;

import teerayut.dev.vlife.payment.delivery.item.ThailandItem;

/**
 * Created by teerayut.k on 7/13/2017.
 */

public interface DeliveryInterface {

    public interface View {
        void setProvince(List<ThailandItem> thailandItemList);
        void setDistrict(List<ThailandItem> thailandItemList);
        void setSubDistrict(List<ThailandItem> thailandItemList);
    }

    public interface Presenter {
        void onLoadProvince();
        void onLoadDistrict(String id);
        void onLoadSubDistrict(String id);
    }
}
