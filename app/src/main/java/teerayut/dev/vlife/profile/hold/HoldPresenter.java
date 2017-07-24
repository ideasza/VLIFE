package teerayut.dev.vlife.profile.hold;

import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.profile.hold.item.HoldItem;

/**
 * Created by teerayut.k on 7/24/2017.
 */

public class HoldPresenter implements HoleInterface.Presenter {

    private HoldItem item;
    private HoleInterface.View view;
    private List<HoldItem> holdItemList = new ArrayList<HoldItem>();
    public HoldPresenter(HoleInterface.View view) {
        this.view = view;
    }

    @Override
    public void requestHold() {

        item = new HoldItem();
        item.setOrderDate("2017-07-10 16:05:36");
        item.setOrderAmount("7");
        item.setMemberCode("0000018");
        item.setOrderType("โฮลล์");
        item.setOrderNumber("49");
        item.setPrice("7650");
        item.setPv("1830");
        holdItemList.add(item);

        view.setHoldToAdapter(holdItemList);

    }
}
