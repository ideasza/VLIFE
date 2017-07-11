package teerayut.dev.vlife.payment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import teerayut.dev.vlife.payment.delivery.DeliveryFragment;
import teerayut.dev.vlife.payment.detail.DetailFragment;
import teerayut.dev.vlife.payment.pay.PayFragment;

/**
 * Created by teerayut.k on 7/11/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return DeliveryFragment.newInstance();
        else if(position == 1)
            return DetailFragment.newInstance();
        else if(position == 2)
            return PayFragment.newInstance();
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
