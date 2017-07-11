package teerayut.dev.vlife.fragment.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.tonyvu.sc.model.Cart;
import com.android.tonyvu.sc.util.CartHelper;
import com.squareup.otto.Subscribe;
import com.thekhaeng.recyclerviewmargin.StaggeredGridLayoutMargin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.cart.CartActivity;
import teerayut.dev.vlife.fragment.home.Item.CartItem;
import teerayut.dev.vlife.fragment.home.Item.ProductItem;
import teerayut.dev.vlife.fragment.home.adapter.HomeAdapter;
import teerayut.dev.vlife.utils.ActivityResultBus;
import teerayut.dev.vlife.utils.ActivityResultEvent;
import teerayut.dev.vlife.utils.Config;
import teerayut.dev.vlife.utils.ExtactCartItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeInterface.View {

    private HomeAdapter adapter;
    private HomeInterface.Presenter presenter;
    private int badgeQuantity = 0;
    private Cart cart = CartHelper.getCart();
    private List<CartItem> cartItemList = Collections.emptyList();
    private List<ProductItem> itemModelList = new ArrayList<ProductItem>();
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        bindView(view);
        return view;
    }

    @BindView(R.id.btn_try_again) Button buttonTryAgain;
    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    @BindView(R.id.container_service_unavailable) FrameLayout containerUnvailable;
    private void bindView(View view) {
        ButterKnife.bind(this, view);
        setView();
    }

    private void setView() {
        containerUnvailable.setVisibility(View.VISIBLE);
        buttonTryAgain.setOnClickListener( onTryAgain() );
        setHasOptionsMenu(true);
        setIntance();
    }

    private void setIntance() {
        presenter = new HomePresenter(this);
        presenter.requestItem();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.shopping_cart, menu);
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
                //Log.e("Item cart", cartItem.getProduct().getName() + " : " + cartItem.getQuantity());
            }
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.badge_cart_item));
            textViewCount.setText("" + badgeQuantity);
        } else {

            imageView.setVisibility(View.GONE);
            textViewCount.setVisibility(View.GONE);
        }
        badgeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivityForResult(new Intent(getActivity(), CartActivity.class), Config.REQUEST_CART);
            }
        });
    }

    @Override
    public void setItemToRecyclerView(List<ProductItem> itemModels) {
        this.itemModelList = itemModels;
        adapter = new HomeAdapter(getActivity(), itemModels);
        int itemSpace = (int) getResources().getDimension( R.dimen.default_padding_margin );
        recyclerView.addItemDecoration( new StaggeredGridLayoutMargin(Config.COLUMN_COUNT, itemSpace ) );
        StaggeredGridLayoutManager layout = new StaggeredGridLayoutManager( Config.COLUMN_COUNT, StaggeredGridLayoutManager.VERTICAL );
        recyclerView.setLayoutManager( layout );
        recyclerView.setAdapter(adapter);
        if (itemModelList.size() > 0) {
            containerUnvailable.setVisibility(View.GONE);
        }
        adapter.setOnClickListener(onClickProduct());
    }

    @Override
    public void showUnvailable() {
        recyclerView.setVisibility( View.GONE );
        containerUnvailable.setVisibility( View.VISIBLE );
    }

    @Override
    public void showAvailable() {
        recyclerView.setVisibility( View.VISIBLE );
        containerUnvailable.setVisibility( View.GONE );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Config.REQUEST_CART) {
            badgeQuantity = 0;
            adapter.notifyDataSetChanged();
            getActivity().invalidateOptionsMenu();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        ActivityResultBus.getInstance().register(mActivityResultSubscriber);
    }

    @Override
    public void onStop() {
        super.onStop();
        ActivityResultBus.getInstance().unregister(mActivityResultSubscriber);
    }

    private Object mActivityResultSubscriber = new Object() {
        @Subscribe
        public void onActivityResultReceived(ActivityResultEvent event) {
            int requestCode = event.getRequestCode();
            int resultCode = event.getResultCode();
            Intent data = event.getData();
            onActivityResult(requestCode, resultCode, data);
        }
    };

    private HomeAdapter.OnClickListener onClickProduct() {
        return new HomeAdapter.OnClickListener() {
            @Override
            public void onClickAdded(ProductItem item, int position) {
                cart.remove(item, 1);
                badgeQuantity = 0;
                getActivity().invalidateOptionsMenu();
        }

            @Override
            public void onClickAddToCart(ProductItem item, int position) {
                Log.e("Selected position", position + ", " + item.getName());
                cart.add(item, 1);
                badgeQuantity = 0;
                getActivity().invalidateOptionsMenu();
            }
        };
    }

    private View.OnClickListener onTryAgain() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.requestItem();
            }
        };
    }
}
