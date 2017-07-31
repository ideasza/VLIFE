package teerayut.dev.vlife.profile.point.clam_history;

import java.util.List;

import teerayut.dev.vlife.profile.point.clam_history.item.ClamItem;

/**
 * Created by teerayut.k on 7/31/2017.
 */

public interface ClamHistoryInterface {

    public interface View {
        void showUnvailable();
        void showAvailable();
        void setClamHistoryToAdapter(List<ClamItem> clamItemList);
    }

    public interface Presenter {
        void requestClamHistory();
    }
}
