package teerayut.dev.vlife.profile.order_history;

import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.profile.order_history.item.OrderHistoryItem;

/**
 * Created by teerayut.k on 7/24/2017.
 */

public class OrderHistoryPresenter implements OrderHistoryInterface.Presenter {

    private OrderHistoryItem item;
    private OrderHistoryInterface.View view;
    private List<OrderHistoryItem> orderHistoryItemList = new ArrayList<OrderHistoryItem>();
    public OrderHistoryPresenter(OrderHistoryInterface.View view) {
        this.view = view;
    }

    @Override
    public void requestOrderHistory() {
        view.showAvailable();

        item = new OrderHistoryItem();
        item.setOrderDate("2017-06-24 16:04:38");
        item.setMemberCode("0000018");
        item.setOrderType("ปกติ");
        item.setOrderNumber("10");
        item.setPrice("4150");
        item.setPv("780");
        orderHistoryItemList.add(item);

        item = new OrderHistoryItem();
        item.setOrderDate("2017-06-24 23:51:12");
        item.setMemberCode("0000018");
        item.setOrderType("โฮลล์");
        item.setOrderNumber("12");
        item.setPrice("6150");
        item.setPv("1080");
        orderHistoryItemList.add(item);

        item = new OrderHistoryItem();
        item.setOrderDate("2017-06-29 22:34:36");
        item.setMemberCode("0000018");
        item.setOrderType("ปกติ");
        item.setOrderNumber("46");
        item.setPrice("550");
        item.setPv("110");
        orderHistoryItemList.add(item);

        item = new OrderHistoryItem();
        item.setOrderDate("2017-07-02 16:31:45");
        item.setMemberCode("0000018");
        item.setOrderType("ปกติ");
        item.setOrderNumber("47");
        item.setPrice("550");
        item.setPv("110");
        orderHistoryItemList.add(item);

        item = new OrderHistoryItem();
        item.setOrderDate("2017-07-10 14:25:36");
        item.setMemberCode("0000025");
        item.setOrderType("ปกติ");
        item.setOrderNumber("48");
        item.setPrice("3050");
        item.setPv("620");
        orderHistoryItemList.add(item);

        item = new OrderHistoryItem();
        item.setOrderDate("2017-07-10 16:05:36");
        item.setMemberCode("0000018");
        item.setOrderType("โฮลล์");
        item.setOrderNumber("49");
        item.setPrice("7650");
        item.setPv("1830");
        orderHistoryItemList.add(item);

        item = new OrderHistoryItem();
        item.setOrderDate("2017-07-12 10:57:53");
        item.setMemberCode("0000018");
        item.setOrderType("ปกติ");
        item.setOrderNumber("50");
        item.setPrice("300");
        item.setPv("150");
        orderHistoryItemList.add(item);

        view.setHistoryToAdapter(orderHistoryItemList);
    }
}
