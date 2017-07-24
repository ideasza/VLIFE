package teerayut.dev.vlife.profile.point.point_history;

import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.profile.point.point_history.item.PointItem;

/**
 * Created by teerayut.k on 7/24/2017.
 */

public class PointHistoryPresenter implements PointHistoryInterface.Presenter {

    private PointItem item;
    private PointHistoryInterface.View view;
    private List<PointItem> pointItems = new ArrayList<PointItem>();
    public PointHistoryPresenter (PointHistoryInterface.View view) {
        this.view = view;
    }

    @Override
    public void requestPointHistory() {

        item = new PointItem();
        item.setOrderDate("2017-06-24 16:04:38");
        item.setOrderNumber("10");
        item.setPointType("ได้รับคะแนน");
        item.setPoint("780");
        pointItems.add(item);

        item = new PointItem();
        item.setOrderDate("2017-06-24 23:51:12");
        item.setOrderNumber("12");
        item.setPointType("ได้รับคะแนน");
        item.setPoint("1080");
        pointItems.add(item);

        item = new PointItem();
        item.setOrderDate("2017-06-29 22:34:36");
        item.setOrderNumber("46");
        item.setPointType("ได้รับคะแนน");
        item.setPoint("110");
        pointItems.add(item);

        item = new PointItem();
        item.setOrderDate("2017-07-02 16:31:45");
        item.setOrderNumber("47");
        item.setPointType("ได้รับคะแนน");
        item.setPoint("110");
        pointItems.add(item);

        item = new PointItem();
        item.setOrderDate("2017-07-10 16:05:36");
        item.setOrderNumber("49");
        item.setPointType("ได้รับคะแนน");
        item.setPoint("1830");
        pointItems.add(item);

        item = new PointItem();
        item.setOrderDate("2017-07-12 10:57:53\t");
        item.setOrderNumber("50");
        item.setPointType("ได้รับคะแนน");
        item.setPoint("150");
        pointItems.add(item);

        item = new PointItem();
        item.setOrderDate("2017-07-20 08:22:13");
        item.setOrderNumber("51");
        item.setPointType("ได้รับคะแนน");
        item.setPoint("110");
        pointItems.add(item);

        view.setPointHistoryToAdapter(pointItems);
    }
}
