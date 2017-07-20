package teerayut.dev.vlife.cart.payment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import teerayut.dev.vlife.cart.payment.delivery.DeliveryFragment;
import teerayut.dev.vlife.cart.payment.detail.DetailFragment;
import teerayut.dev.vlife.cart.payment.pay.PayFragment;
import teerayut.dev.vlife.cart.payment.summary.SummaryFragment;

/**
 * Created by teerayut.k on 7/11/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return DeliveryFragment.newInstance();
            case 1:
                return DetailFragment.newInstance();
            case 2:
                return PayFragment.newInstance();
            case 3:
                return SummaryFragment.newInstance();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
