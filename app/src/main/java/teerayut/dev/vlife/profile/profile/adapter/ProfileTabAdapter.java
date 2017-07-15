package teerayut.dev.vlife.profile.profile.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import teerayut.dev.vlife.profile.profile.viewpager.tab1.PersonalFragment;
import teerayut.dev.vlife.profile.profile.viewpager.tab2.SendingAddressFragment;

/**
 * Created by teerayut.k on 7/15/2017.
 */

public class ProfileTabAdapter extends FragmentStatePagerAdapter {

    private int tabNumber;
    public ProfileTabAdapter(FragmentManager fm, int tabNumber) {
        super(fm);
        this.tabNumber = tabNumber;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return PersonalFragment.newInstance();
        }else if(position == 1) {
            return SendingAddressFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
