package teerayut.dev.vlife.profile.commission.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import teerayut.dev.vlife.profile.commission.day.DayCommissionFragment;
import teerayut.dev.vlife.profile.commission.month.MonthCommissionFragment;
import teerayut.dev.vlife.profile.commission.travel.TravelCommissionFragment;
import teerayut.dev.vlife.profile.commission.year.YearCommissionFragment;

/**
 * Created by teerayut.k on 7/20/2017.
 */

public class CommissionTabAdapter extends FragmentStatePagerAdapter {

    private int tabNumber;
    public CommissionTabAdapter(FragmentManager fm, int tabNumber) {
        super(fm);
        this.tabNumber = tabNumber;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return DayCommissionFragment.newInstance();
            case 1:
                return MonthCommissionFragment.newInstance();
            case 2:
                return YearCommissionFragment.newInstance();
            case 3:
                return TravelCommissionFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
