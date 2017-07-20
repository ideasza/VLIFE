package teerayut.dev.vlife.profile.commission;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.profile.commission.adapter.CommissionTabAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommissionFragment extends Fragment {


    public CommissionFragment() {
        // Required empty public constructor
    }

    private View view;
    private CommissionTabAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_commission, container, false);
        bindView();
        return view;
    }

    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.commission_tab_layout) TabLayout tabLayout;
    private void bindView() {
        ButterKnife.bind(this, view);
        setTabView();
    }

    private void setTabView() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.title_commission_day));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.title_commission_month));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.title_commission_year));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.title_commission_travel));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setFillViewport(true);
        adapter = new CommissionTabAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
