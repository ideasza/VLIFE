package teerayut.dev.vlife.register.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import teerayut.dev.vlife.register.address.RegisterAddressFragment;
import teerayut.dev.vlife.register.register_main.RegisterMainFragment;
import teerayut.dev.vlife.register.register_partner.RegisterPartnerFragment;
import teerayut.dev.vlife.register.sending_address.RegisterSendingAddressFragment;

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
                return RegisterMainFragment.newInstance();
            case 1:
                return RegisterPartnerFragment.newInstance();
            case 2:
                return RegisterAddressFragment.newInstance();
            case 3:
                return RegisterSendingAddressFragment.newInstance();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
