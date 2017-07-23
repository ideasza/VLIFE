package teerayut.dev.vlife.profile.point;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.profile.point.adapter.PointTabAdapter;
import teerayut.dev.vlife.profile.profile.adapter.ProfileTabAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PointFragment extends Fragment {


    public PointFragment() {
        // Required empty public constructor
    }

    private View view;
    private PointTabAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_point, container, false);
        bindView();
        return view;
    }

    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.detail_tabs) TabLayout tabLayout;
    private void bindView() {
        ButterKnife.bind(this, view);
        setTabView();
    }

    private void setTabView() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.profile_menu_point));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.profile_menu_redeem_history));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setFillViewport(true);
        adapter = new PointTabAdapter(getFragmentManager());
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
