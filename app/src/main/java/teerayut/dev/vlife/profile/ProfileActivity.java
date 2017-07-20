package teerayut.dev.vlife.profile;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.main.MainActivity;
import teerayut.dev.vlife.profile.commission.CommissionFragment;
import teerayut.dev.vlife.profile.order_history.OrderHistoryFragment;
import teerayut.dev.vlife.profile.profile.ProfileFragment;
import teerayut.dev.vlife.utils.ActivityResultBus;
import teerayut.dev.vlife.utils.ActivityResultEvent;

public class ProfileActivity extends AppCompatActivity {

    private MenuItem menuItemClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bindView();

        if (savedInstanceState == null) {
            loadHomePage();
        }
    }

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer) DrawerLayout drawerLayout;
    @BindView(R.id.navigation_view) NavigationView navigationView;
    private void bindView() {
        ButterKnife.bind(this);
        setToolbar();
        setProfileMenu();
    }

    private void setToolbar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    private void loadHomePage() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, new ProfileFragment()).addToBackStack(null).commit();
        toolbar.setTitle(getResources().getString(R.string.main_menu_profile));
    }

    private void setProfileMenu() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on Item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItemClicked = menuItem;
                drawerLayout.closeDrawers();
                return true;
            }
        });
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView.inflateMenu(R.menu.profile_menu);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_Drawer, R.string.close_Drawer)
                {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if(menuItemClicked != null)
                    handleSelectedMenu(menuItemClicked);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                menuItemClicked = null;
            }
        };
        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_menu_white_36dp);
        actionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void handleSelectedMenu(MenuItem menuItem) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame);
        switch (menuItem.getItemId()){
            case R.id.profile_home :
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.profile_profile :
                toolbar.setTitle(getResources().getString(R.string.main_menu_profile));
                if (currentFragment instanceof ProfileFragment) {
                    drawerLayout.closeDrawers();
                } else {
                    transaction.replace(R.id.frame, new ProfileFragment(), "ProfileFragment").addToBackStack(null).commit();
                }
                break;
            case R.id.profile_order_history :
                toolbar.setTitle(getResources().getString(R.string.profile_menu_buy_history));
                if (currentFragment instanceof OrderHistoryFragment) {
                    drawerLayout.closeDrawers();
                } else {
                    transaction.replace(R.id.frame, new OrderHistoryFragment(), "OrderHistoryFragment").addToBackStack(null).commit();
                }
                break;
            case R.id.profile_bill_hold :
                break;
            case R.id.profile_my_point :
                break;
            case R.id.profile_redeem_history :
                break;
            case R.id.profile_recomend :
                break;
            case R.id.profile_upline :
                break;
            case R.id.profile_com :
                toolbar.setTitle(getResources().getString(R.string.profile_menu_comission));
                if (currentFragment instanceof CommissionFragment) {
                    drawerLayout.closeDrawers();
                } else {
                    transaction.replace(R.id.frame, new CommissionFragment(), "CommissionFragment").addToBackStack(null).commit();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityResultBus.getInstance().postQueue(new ActivityResultEvent(requestCode, resultCode, data));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame);
            if (currentFragment instanceof ProfileFragment) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                finish();
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
