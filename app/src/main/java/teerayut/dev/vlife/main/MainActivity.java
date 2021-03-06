package teerayut.dev.vlife.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tonyvu.sc.model.Cart;
import com.android.tonyvu.sc.util.CartHelper;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.authentication.AuthenticationActivity;
import teerayut.dev.vlife.base.BaseMvpActivity;
import teerayut.dev.vlife.home.HomeFragment;
import teerayut.dev.vlife.home.Item.CartItem;
import teerayut.dev.vlife.news.NewsFragment;
import teerayut.dev.vlife.paid.PaidFragment;
import teerayut.dev.vlife.profile.ProfileActivity;
import teerayut.dev.vlife.register.RegisterActivity;
import teerayut.dev.vlife.utils.ActivityResultBus;
import teerayut.dev.vlife.utils.ActivityResultEvent;
import teerayut.dev.vlife.utils.Config;
import teerayut.dev.vlife.utils.MyApplication;

/**
 * Created by teerayut.k on 7/9/2017.
 */

public class MainActivity extends BaseMvpActivity<MainInterface.Presenter> implements MainInterface.View {

    private Snackbar snackbar;
    private MenuItem menuItemClicked;

    private ImageView imageView;
    private TextView textViewName;

    private boolean clickBackAain = false;

    private String token;
    private int badgeQuantity = 0;
    private Cart cart = CartHelper.getCart();
    List<CartItem> cartItemList = Collections.emptyList();

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer) DrawerLayout drawerLayout;
    @BindView(R.id.navigation_view) NavigationView navigationView;
    @Override
    public void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    public void setupInstance() {

    }

    @Override
    public void setupView() {
        setToolbar();
        setMainMenu();
        loginSession();
    }

    @Override
    public void initialize() {
        /*try {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(Long.parseLong(MyApplication.getInstance().getPrefManager().getPreferrence(Config.KEY_EXPIRE)));
            int dayNum = c.get(Calendar.DAY_OF_MONTH);
            if (dayNum > 30) {
                getPresenter().getAccessToken();
                setAccessToken(getPresenter().getToken());
            } else {
                setAccessToken(getPresenter().getToken());
            }
        } catch (Exception ex) {
            getPresenter().getAccessToken();
            setAccessToken(getPresenter().getToken());
        }*/
        //getPresenter().getAccessToken();
        //setAccessToken(getPresenter().getToken());
        loadHomePage();
    }

    @Override
    public MainInterface.Presenter createPresenter() {
        return MainPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Config.KEY_TOKEN, getPresenter().getToken());
    }

    @Override
    public void restoreView(Bundle savedInstanceState) {
        super.restoreView(savedInstanceState);
        MyApplication.getInstance().getPrefManager().setPreferrence(Config.KEY_TOKEN,
                getPresenter().getToken());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        getPresenter().setAccessToken((String) savedInstanceState.getString(Config.KEY_TOKEN));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityResultBus.getInstance().postQueue(new ActivityResultEvent(requestCode, resultCode, data));
        if (requestCode == Config.REQUEST_REGISTER) {
            loginSession();
        } else if (requestCode == Config.REQUEST_LOGIN) {
            loginSession();
        }
    }

    private void loadHomePage() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, HomeFragment.newInstance(), "HomeFragment").addToBackStack(null).commit();
    }

    private void setToolbar() {
        toolbar.setTitle(getResources().getString(R.string.main_menu_product));
        setSupportActionBar(toolbar);
    }

    private void setMainMenu() {
        LayoutInflater inflater = getLayoutInflater();
        View header = inflater.inflate(R.layout.menu_header, null, false);
        imageView = (ImageView) header.findViewById(R.id.image_profile);
        textViewName = (TextView) header.findViewById(R.id.name);

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
        navigationView.inflateMenu(R.menu.main_menu);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){
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
            case R.id.menu_product:
                toolbar.setTitle(navigationView.getMenu().getItem(0).getTitle());
                if (currentFragment instanceof HomeFragment) {
                    drawerLayout.closeDrawers();
                } else {
                    transaction.replace(R.id.frame, HomeFragment.newInstance(), "HomeFragment").addToBackStack(null).commit();
                }
                break;
            case R.id.menu_news:
                toolbar.setTitle(navigationView.getMenu().getItem(1).getTitle());
                if (currentFragment instanceof NewsFragment) {
                    drawerLayout.closeDrawers();
                } else {
                    transaction.replace(R.id.frame, new NewsFragment(), "NewsFragment").addToBackStack(null).commit();
                }
                break;
            case R.id.menu_purchase:
                toolbar.setTitle(navigationView.getMenu().getItem(2).getTitle());
                if (currentFragment instanceof PaidFragment) {
                    drawerLayout.closeDrawers();
                } else {
                    transaction.replace(R.id.frame, new PaidFragment(), "PaidFragment").addToBackStack(null).commit();
                }
                break;
            case R.id.menu_login :
                startActivityForResult(new Intent(MainActivity.this, AuthenticationActivity.class), Config.REQUEST_LOGIN);
                break;
            case R.id.menu_profile:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                finish();
                break;
            case R.id.menu_register:
                startActivityForResult(new Intent(MainActivity.this, RegisterActivity.class), Config.REQUEST_REGISTER);
                break;
            case R.id.menu_settings:
                snackbar = Snackbar.make(drawerLayout, "Settings", Snackbar.LENGTH_LONG);
                snackbar.show();
                break;
            case R.id.menu_logout :
                MyApplication.getInstance().getPrefManager().setPreferrenceBoolean(Config.KEY_SESSION_LOGIN, false);
                startActivityForResult(new Intent(MainActivity.this, AuthenticationActivity.class), Config.REQUEST_LOGIN);
                break;
            default:
                /*snackbar = Snackbar.make(drawerLayout, "Somethings Wrong", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();*/
                loadHomePage();
                break;
        }
    }

    private void loginSession() {
        try {
            if (MyApplication.getInstance().getPrefManager().getPreferrenceBoolean(Config.KEY_SESSION_LOGIN)) {
                setMenuItemWithLogin();
            } else {
                setMenuItemWithoutLogin();
            }
        } catch (Exception e) {
            MyApplication.getInstance().getPrefManager().setPreferrenceBoolean(Config.KEY_SESSION_LOGIN, false);
            setMenuItemWithoutLogin();
        }
    }

    private void setMenuItemWithLogin() {
        Menu menu = navigationView.getMenu();
        MenuItem menuItemLogin = menu.findItem(R.id.menu_login);
        menuItemLogin.setVisible(false);

        MenuItem menuItemProfile = menu.findItem(R.id.menu_profile);
        menuItemProfile.setVisible(true);
        MenuItem menuItemSettings = menu.findItem(R.id.menu_settings);
        menuItemSettings.setVisible(true);
        MenuItem menuItemLogout = menu.findItem(R.id.menu_logout);
        menuItemLogout.setVisible(true);
    }

    private void setMenuItemWithoutLogin() {
        Menu menu = navigationView.getMenu();
        MenuItem menuItemLogin = menu.findItem(R.id.menu_login);
        menuItemLogin.setVisible(true);

        MenuItem menuItemProfile = menu.findItem(R.id.menu_profile);
        menuItemProfile.setVisible(false);
        MenuItem menuItemSettings = menu.findItem(R.id.menu_settings);
        menuItemSettings.setVisible(false);
        MenuItem menuItemLogout = menu.findItem(R.id.menu_logout);
        menuItemLogout.setVisible(false);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            if (clickBackAain) {
                finish();
                return true;
            }
            this.clickBackAain = true;
            Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    clickBackAain=false;
                }
            }, 2000);
            return false;
        }
        return true;
    }

    @Override
    public void setAccessToken(String token) {
        Log.e("New token", token);
        this.token = token;
    }

    @Override
    public String getAccessToken() {
        return token;
    }
}
