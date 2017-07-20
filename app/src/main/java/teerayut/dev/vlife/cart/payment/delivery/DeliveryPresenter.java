package teerayut.dev.vlife.cart.payment.delivery;

import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.cart.payment.delivery.item.ThailandItem;

/**
 * Created by teerayut.k on 7/13/2017.
 */

public class DeliveryPresenter implements DeliveryInterface.Presenter {

    private ThailandItem item;
    private DeliveryInterface.View view;
    private List<ThailandItem> thailandItemList = new ArrayList<ThailandItem>();
    public DeliveryPresenter(DeliveryInterface.View view) {
        this.view = view;
    }

    @Override
    public void onLoadProvince() {
        item = new ThailandItem("1", "กรุงเทพฯ");
        thailandItemList.add(item);

        item = new ThailandItem("2", "นนทบุรี");
        thailandItemList.add(item);

        item = new ThailandItem("3", "นครสวรรค์");
        thailandItemList.add(item);

        item = new ThailandItem("4", "สมุทรปราการ");
        thailandItemList.add(item);

        item = new ThailandItem("5", "อยุธยา");
        thailandItemList.add(item);

        view.setProvince(thailandItemList);
    }

    @Override
    public void onLoadDistrict(String id) {
        thailandItemList.clear();

        item = new ThailandItem("1", "จตุจักร");
        thailandItemList.add(item);

        item = new ThailandItem("2", "บางบัวทอง");
        thailandItemList.add(item);

        item = new ThailandItem("3", "ชุมแสง");
        thailandItemList.add(item);

        item = new ThailandItem("4", "เมือง");
        thailandItemList.add(item);

        item = new ThailandItem("5", "เมือง");
        thailandItemList.add(item);

        view.setDistrict(thailandItemList);

    }

    @Override
    public void onLoadSubDistrict(String id) {
        thailandItemList.clear();

        item = new ThailandItem("1", "คลองจั่น");
        thailandItemList.add(item);

        item = new ThailandItem("2", "บางคูรัด");
        thailandItemList.add(item);

        item = new ThailandItem("3", "ท่าไม้");
        thailandItemList.add(item);

        item = new ThailandItem("4", "ท้ายบ้านใหม่");
        thailandItemList.add(item);

        item = new ThailandItem("5", "เมืองอยุธยา");
        thailandItemList.add(item);

        view.setSubDistrict(thailandItemList);
    }
}
