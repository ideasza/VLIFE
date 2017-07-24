package teerayut.dev.vlife.profile.order_history;

import java.util.List;

import teerayut.dev.vlife.profile.order_history.item.OrderHistoryItem;

/**
 * Created by teerayut.k on 7/24/2017.
 */

public interface OrderHistoryInterface {

    public interface View {
        void showUnvailable();
        void showAvailable();
        void setHistoryToAdapter(List<OrderHistoryItem> orderHistoryItemList);
    }

    public interface Presenter {
        void requestOrderHistory();
    }
}
