package teerayut.dev.vlife.profile.point.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import teerayut.dev.vlife.profile.point.clam_history.ClamHistoryFragment;
import teerayut.dev.vlife.profile.point.point_history.PointHistoryFragment;

/**
 * Created by OzoeSK on 7/23/2017.
 */

public class PointTabAdapter extends FragmentStatePagerAdapter {

    public PointTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return PointHistoryFragment.newInstance();
        } else if (position == 1) {
            return ClamHistoryFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
