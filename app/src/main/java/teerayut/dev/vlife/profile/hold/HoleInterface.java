package teerayut.dev.vlife.profile.hold;

import java.util.List;

import teerayut.dev.vlife.profile.hold.item.HoldItem;

/**
 * Created by teerayut.k on 7/24/2017.
 */

public interface HoleInterface  {

    public interface View {
        void showUnvailable();
        void showAvailable();
        void setHoldToAdapter(List<HoldItem> holdItemList);
    }

    public interface Presenter {
        void requestHold();
    }
}
