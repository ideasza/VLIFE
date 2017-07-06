package teerayut.dev.vlife.main;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.authentication.AuthenticationActivity;
import teerayut.dev.vlife.base.BaseMvpActivity;
import teerayut.dev.vlife.fragment.firstpage.HomeFragment;
import teerayut.dev.vlife.fragment.news.NewsFragment;
import teerayut.dev.vlife.fragment.product.ProductFragment;
import teerayut.dev.vlife.register.RegisterActivity;
import teerayut.dev.vlife.utils.ActivityResultBus;
import teerayut.dev.vlife.utils.ActivityResultEvent;
import teerayut.dev.vlife.utils.Config;
import teerayut.dev.vlife.utils.MyApplication;

public class MainActivity extends BaseMvpActivity<MainInterface.Presenter> implements MainInterface.View {

    private Snackbar snackbar;
    private MenuItem menuItemClicked;

    private ImageView imageView;
    private TextView textViewName, textViewEmail;

    @Override
    public MainInterface.Presenter createPresenter() {
        return MainPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_main;
    }

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
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setToolbar();
        setMainMenu();
        loadHomePage();
    }

    @Override
    public void initialize() {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityResultBus.getInstance().postQueue(new ActivityResultEvent(requestCode, resultCode, data));
        if (requestCode == Config.REQUEST_LOGIN) {
            if (resultCode == RESULT_CANCELED) {
                menuItemClicked = null;
                loginSession(navigationView.getMenu());
                navigationView.getMenu().getItem(6).setChecked(false);
            }
        }
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setMainMenu() {
        //Set header to navigation menu
        LayoutInflater inflater = getLayoutInflater();
        View header = inflater.inflate(R.layout.menu_header, null, false);
        imageView = (ImageView) header.findViewById(R.id.image_profile);
        textViewName = (TextView) header.findViewById(R.id.name);
        textViewEmail = (TextView) header.findViewById(R.id.email);
        //Setting Navigation View Item Selected Listener to handle the Item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on Item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Checking if the Item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked())
                    menuItem.setChecked(false);
                else
                    menuItem.setChecked(true);

                menuItemClicked = menuItem;
                //Closing drawer on Item click
                drawerLayout.closeDrawers();
                return true;
            }
        });
        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){
            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
                if(menuItemClicked != null)
                    handleSelectedMenu(menuItemClicked);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //navigationView.getMenu().getItem(0).setChecked(true);
        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

        loginSession(navigationView.getMenu());
    }

    private void handleSelectedMenu(MenuItem menuItem) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame);
        //Check to see which Item was being clicked and perform appropriate action
        switch (menuItem.getItemId()){
            //Replacing the main content with ContentFragment Which is our Inbox View;
            case R.id.menu_home:
                if (currentFragment instanceof HomeFragment) {
                    drawerLayout.closeDrawers();
                } else {
                    transaction.replace(R.id.frame, new HomeFragment(), "HomeFragment").addToBackStack(null).commit();
                }
                break;
            case R.id.menu_profile:
                Toast.makeText(getApplicationContext(),"Stared Selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_register:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                break;
            case R.id.menu_news:
                toolbar.setTitle(navigationView.getMenu().getItem(3).getTitle());
                if (currentFragment instanceof NewsFragment) {
                    drawerLayout.closeDrawers();
                } else {
                    transaction.replace(R.id.frame, new NewsFragment(), "NewsFragment").addToBackStack(null).commit();
                }
                break;
            case R.id.menu_product:
                toolbar.setTitle(navigationView.getMenu().getItem(4).getTitle());
                if (currentFragment instanceof ProductFragment) {
                    drawerLayout.closeDrawers();
                } else {
                    transaction.replace(R.id.frame, new ProductFragment(), "ProductFragment").addToBackStack(null).commit();
                }
                break;
            case R.id.menu_purchase:
                toolbar.setTitle(navigationView.getMenu().getItem(0).getTitle());
                Toast.makeText(getApplicationContext(),"Trash Selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                snackbar = Snackbar.make(drawerLayout, "Settings", Snackbar.LENGTH_LONG);
                snackbar.show();
                break;
            case R.id.menu_login :
                startActivityForResult(new Intent(getApplicationContext(), AuthenticationActivity.class), Config.REQUEST_LOGIN);
                break;
            case R.id.menu_logout :
                startActivityForResult(new Intent(getApplicationContext(), AuthenticationActivity.class), Config.REQUEST_LOGIN);
                break;
            default:
                snackbar = Snackbar.make(drawerLayout, "Somethings Wrong", Snackbar.LENGTH_LONG);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
                break;
        }
    }

    private void loadHomePage() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, new HomeFragment()).addToBackStack(null).commit();
    }

    private void loginSession(Menu menu) {
        try {
            if (!MyApplication.getInstance().getPrefManager().getPreferrenceBoolean(Config.KEY_SESSION_LOGIN)) {
                MenuItem profile = menu.findItem(R.id.menu_profile);
                profile.setVisible(false);
                MenuItem setting = menu.findItem(R.id.menu_settings);
                setting.setVisible(false);
                MenuItem logout = menu.findItem(R.id.menu_logout);
                logout.setVisible(false);
                MenuItem login = menu.findItem(R.id.menu_login);
                login.setVisible(true);
            } else {
                MenuItem profile = menu.findItem(R.id.menu_profile);
                profile.setVisible(true);
                MenuItem setting = menu.findItem(R.id.menu_settings);
                setting.setVisible(true);
                MenuItem logout = menu.findItem(R.id.menu_logout);
                logout.setVisible(true);
                MenuItem login = menu.findItem(R.id.menu_login);
                login.setVisible(false);
            }
        } catch (Exception e) {
            MenuItem profile = menu.findItem(R.id.menu_profile);
            profile.setVisible(false);
            MenuItem setting = menu.findItem(R.id.menu_settings);
            setting.setVisible(false);
            MenuItem logout = menu.findItem(R.id.menu_logout);
            logout.setVisible(false);
            MenuItem login = menu.findItem(R.id.menu_login);
            login.setVisible(true);
        }
    }

    private void setHeaderMenu() {

    }
}
