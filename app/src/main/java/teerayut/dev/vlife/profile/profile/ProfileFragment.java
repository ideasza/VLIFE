package teerayut.dev.vlife.profile.profile;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.profile.profile.adapter.ProfileTabAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    private View view;
    private ProfileTabAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        bindView();
        return view;
    }

    @BindView(R.id.profile_name) TextView username;
    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.detail_tabs) TabLayout tabLayout;
    private void bindView() {
        ButterKnife.bind(this, view);
        setView();
    }

    private void setView() {
        username.setText(getResources().getString(R.string.username));
        setTabView();
    }

    private void setTabView() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab1_title));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab2_title));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        adapter = new ProfileTabAdapter(getFragmentManager(), tabLayout.getTabCount());
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
