package teerayut.dev.vlife.profile.profile;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;

public class ProfileActivity extends AppCompatActivity {

    private MenuItem menuItemClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bindView();
    }

    @BindView(R.id.toolbarProfile) Toolbar toolbar;
    @BindView(R.id.drawerProfile) DrawerLayout drawerLayout;
    @BindView(R.id.navigation_view) NavigationView navigationView;
    private void bindView() {
        ButterKnife.bind(this);
        setView();
    }

    private void setView() {
        setProfileMenu();
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
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerProfile);
        navigationView.inflateMenu(R.menu.profile_menu);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer){
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
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void handleSelectedMenu(MenuItem menuItem) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame);
        switch (menuItem.getItemId()){
            case R.id.profile_home :
                break;
            case R.id.profile_profile :
                break;
            case R.id.profile_order_history :
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
            default:
                break;
        }
    }
}
