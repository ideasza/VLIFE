package teerayut.dev.vlife.profile.point.clam_history;

import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.profile.point.clam_history.item.ClamItem;

/**
 * Created by teerayut.k on 7/31/2017.
 */

public class ClamHistoryPresenter implements ClamHistoryInterface.Presenter {

    private ClamItem item;
    private ClamHistoryInterface.View view;
    private List<ClamItem> clamItems = new ArrayList<ClamItem>();
    public ClamHistoryPresenter(ClamHistoryInterface.View view) {
        this.view = view;
    }
    @Override
    public void requestClamHistory() {

        item = new ClamItem();
        item.setClamDate("24-04-16\n16:23:45");
        item.setClamDetail("บัตรเงินสด STARBUCKS มูลค่า 50 บาท");
        item.setClamStatus("ใช้คะแนน");
        item.setClamPoints("-50");
        clamItems.add(item);

        item = new ClamItem();
        item.setClamDate("24-04-16\n16:23:45");
        item.setClamDetail("บัตรเงินสด STARBUCKS มูลค่า 50 บาท");
        item.setClamStatus("ใช้คะแนน");
        item.setClamPoints("-50");
        clamItems.add(item);

        item = new ClamItem();
        item.setClamDate("24-04-16\n16:23:45");
        item.setClamDetail("บัตรเงินสด STARBUCKS มูลค่า 50 บาท");
        item.setClamStatus("ใช้คะแนน");
        item.setClamPoints("-50");
        clamItems.add(item);

        item = new ClamItem();
        item.setClamDate("24-04-16\n16:23:45");
        item.setClamDetail("บัตรเงินสด STARBUCKS มูลค่า 50 บาท");
        item.setClamStatus("ใช้คะแนน");
        item.setClamPoints("-50");
        clamItems.add(item);

        item = new ClamItem();
        item.setClamDate("24-04-16\n16:23:45");
        item.setClamDetail("บัตรเงินสด STARBUCKS มูลค่า 50 บาท");
        item.setClamStatus("ใช้คะแนน");
        item.setClamPoints("-50");
        clamItems.add(item);

        item = new ClamItem();
        item.setClamDate("24-04-16\n16:23:45");
        item.setClamDetail("บัตรเงินสด STARBUCKS มูลค่า 50 บาท");
        item.setClamStatus("ใช้คะแนน");
        item.setClamPoints("-50");
        clamItems.add(item);

        item = new ClamItem();
        item.setClamDate("24-04-16\n16:23:45");
        item.setClamDetail("บัตรเงินสด STARBUCKS มูลค่า 50 บาท");
        item.setClamStatus("ใช้คะแนน");
        item.setClamPoints("-50");
        clamItems.add(item);

        item = new ClamItem();
        item.setClamDate("24-04-16\n16:23:45");
        item.setClamDetail("บัตรเงินสด STARBUCKS มูลค่า 50 บาท");
        item.setClamStatus("ใช้คะแนน");
        item.setClamPoints("-50");
        clamItems.add(item);

        item = new ClamItem();
        item.setClamDate("24-04-16\n16:23:45");
        item.setClamDetail("บัตรเงินสด STARBUCKS มูลค่า 50 บาท");
        item.setClamStatus("ใช้คะแนน");
        item.setClamPoints("-50");
        clamItems.add(item);

        item = new ClamItem();
        item.setClamDate("24-04-16\n16:23:45");
        item.setClamDetail("บัตรเงินสด STARBUCKS มูลค่า 50 บาท");
        item.setClamStatus("ใช้คะแนน");
        item.setClamPoints("-50");
        clamItems.add(item);

        view.setClamHistoryToAdapter(clamItems);
    }
}
