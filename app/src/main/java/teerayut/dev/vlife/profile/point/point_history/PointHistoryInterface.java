package teerayut.dev.vlife.profile.point.point_history;

import java.util.List;

import teerayut.dev.vlife.profile.point.point_history.item.PointItem;

/**
 * Created by teerayut.k on 7/24/2017.
 */

public interface PointHistoryInterface {

    public interface View {
        void showUnvailable();
        void showAvailable();
        void setPointHistoryToAdapter(List<PointItem> pointItems);
    }

    public interface Presenter {
        void requestPointHistory();
    }
}
