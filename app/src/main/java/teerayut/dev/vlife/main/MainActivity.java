package teerayut.dev.vlife.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tonyvu.sc.model.Cart;
import com.android.tonyvu.sc.util.CartHelper;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.fragment.home.HomeFragment;
import teerayut.dev.vlife.fragment.home.Item.CartItem;
import teerayut.dev.vlife.utils.ActivityResultBus;
import teerayut.dev.vlife.utils.ActivityResultEvent;
import teerayut.dev.vlife.utils.Config;
import teerayut.dev.vlife.utils.ExtactCartItem;

/**
 * Created by teerayut.k on 7/9/2017.
 */

public class MainActivity extends AppCompatActivity {

    private Snackbar snackbar;
    private MenuItem menuItemClicked;

    private ImageView imageView;
    private TextView textViewName, textViewEmail;

    private int badgeQuantity = 0;
    private Cart cart = CartHelper.getCart();
    List<CartItem> cartItemList = Collections.emptyList();

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer) DrawerLayout drawerLayout;
    @BindView(R.id.navigation_view) NavigationView navigationView;
    private void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setView();

        if (savedInstanceState == null) {
            loadHomePage();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityResultBus.getInstance().postQueue(new ActivityResultEvent(requestCode, resultCode, data));
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shopping_cart, menu);
        MenuItem item = menu.findItem(R.id.action_cart);
        MenuItemCompat.setActionView(item, R.layout.counter_menuitem_layout);
        RelativeLayout badgeLayout = (RelativeLayout) MenuItemCompat.getActionView(item);
        ImageView imageView = (ImageView) badgeLayout.findViewById(R.id.counterBackground);
        TextView textViewCount = (TextView) badgeLayout.findViewById(R.id.count);

        cartItemList = new ExtactCartItem().getCartItems(cart);
        if (cartItemList.size() > 0) {
            for (int i = 0; i < cartItemList.size(); i ++) {
                final CartItem cartItem = cartItemList.get(i);
                badgeQuantity += Integer.parseInt(cartItem.getQuantity() + "");
                Log.e("Item cart", cartItem.getProduct().getName() + " : " + cartItem.getQuantity());
            }
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.badge_cart_item));
            textViewCount.setText("" + badgeQuantity);
        } else {
            badgeQuantity = 0;
            imageView.setVisibility(View.GONE);
            textViewCount.setVisibility(View.GONE);
        }

        badgeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivityForResult(new Intent(getApplicationContext(), CartActivity.class), SHOPPING_CART);
            }
        });

        return super.onCreateOptionsMenu(menu);
    }*/

    private void setView() {
        setToolbar();
        setMainMenu();
    }

    private void loadHomePage() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, new HomeFragment()).addToBackStack(null).commit();
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
    }

    private void setMainMenu() {
        LayoutInflater inflater = getLayoutInflater();
        View header = inflater.inflate(R.layout.menu_header, null, false);
        imageView = (ImageView) header.findViewById(R.id.image_profile);
        textViewName = (TextView) header.findViewById(R.id.name);
        textViewEmail = (TextView) header.findViewById(R.id.email);

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
                //startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                break;
            case R.id.menu_news:
                toolbar.setTitle(navigationView.getMenu().getItem(3).getTitle());
                /*if (currentFragment instanceof NewsFragment) {
                    drawerLayout.closeDrawers();
                } else {
                    transaction.replace(R.id.frame, new NewsFragment(), "NewsFragment").addToBackStack(null).commit();
                }*/
                break;
            case R.id.menu_product:
                toolbar.setTitle(navigationView.getMenu().getItem(4).getTitle());
                /*if (currentFragment instanceof ProductFragment) {
                    drawerLayout.closeDrawers();
                } else {
                    transaction.replace(R.id.frame, new ProductFragment(), "ProductFragment").addToBackStack(null).commit();
                }*/
                break;
            case R.id.menu_purchase:
                toolbar.setTitle(navigationView.getMenu().getItem(0).getTitle());
                Toast.makeText(getApplicationContext(),"Trash Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                snackbar = Snackbar.make(drawerLayout, "Settings", Snackbar.LENGTH_LONG);
                snackbar.show();
                break;
            case R.id.menu_login :
                //startActivityForResult(new Intent(getApplicationContext(), AuthenticationActivity.class), Config.REQUEST_LOGIN);
                break;
            case R.id.menu_logout :
                //startActivityForResult(new Intent(getApplicationContext(), AuthenticationActivity.class), Config.REQUEST_LOGIN);
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
}
