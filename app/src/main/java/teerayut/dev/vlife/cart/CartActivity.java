package teerayut.dev.vlife.cart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.tonyvu.sc.model.Cart;
import com.android.tonyvu.sc.util.CartHelper;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.cart.adapter.CartAdapter;
import teerayut.dev.vlife.home.Item.CartItem;
import teerayut.dev.vlife.cart.payment.PaymentActivity;
import teerayut.dev.vlife.utils.AnimateButton;
import teerayut.dev.vlife.utils.Config;
import teerayut.dev.vlife.utils.ExtactCartItem;

public class CartActivity extends AppCompatActivity implements CartAdapter.ClickListener{

    private int pv = 0;
    private int price = 0;
    private CartAdapter adapter;
    private Cart cart = CartHelper.getCart();
    private List<CartItem> cartItemList = Collections.emptyList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        bindView();
        setView();
    }

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    @BindView(R.id.textViewPv) TextView textPV;
    @BindView(R.id.textViewTotal) TextView textTotalPrice;
    @BindView(R.id.button_payment) Button buttonPayment;
    @BindView(R.id.container_cart_empty) FrameLayout containerCartEmpty;
    private void bindView() {
        ButterKnife.bind(this);
    }

    private void setView() {
        setToolbar();
        setCartItem();
        buttonPayment.setOnClickListener( onPayment() );
    }

    private void setToolbar() {
        toolbar.setTitle(getResources().getString(R.string.cart_title));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setCartItem() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CartActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        prepareItem();
    }

    private void prepareItem() {
        cartItemList = new ExtactCartItem().getCartItems(cart);
        if (cartItemList.size() > 0) {
            adapter = new CartAdapter(CartActivity.this, cartItemList);
            recyclerView.setAdapter(adapter);
            adapter.setClickListener(this);
            getCartItem(cartItemList);
        } else {
            containerCartEmpty.setVisibility(View.VISIBLE);
            textPV.setText("0");
            textTotalPrice.setText("0" + " " + getResources().getString(R.string.price_symbol));
        }
    }

    private void getCartItem(List<CartItem> cartItems) {
        CartItem cartItem = null;
        if (cartItems.size() > 0) {
            for (int i = 0; i < cartItems.size(); i++) {
                cartItem = cartItemList.get(i);
                pv += (cartItem.getQuantity() * new Double(cartItemList.get(i).getProduct().getPv()).intValue());
                price += (cartItem.getQuantity() * Integer.parseInt(cartItem.getProduct().getPrice() + ""));
            }

            textPV.setText(String.valueOf(String.format("%,d", pv)));
            textTotalPrice.setText(String.valueOf(String.format("%,d", price)) + " " + getResources().getString(R.string.price_symbol));
        } else {
            containerCartEmpty.setVisibility(View.VISIBLE);
            textPV.setText("0");
            textTotalPrice.setText("0" + " " + getResources().getString(R.string.price_symbol));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            setResult(RESULT_CANCELED);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener onPayment() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPayment.startAnimation(new AnimateButton().animbutton());
                startActivityForResult(new Intent(getApplicationContext(), PaymentActivity.class), Config.REQUEST_PAYMENT);
            }
        };
    }

    @Override
    public void increase(View view, int position) {
        CartItem cartItem = cartItemList.get(position);
        cartItem.setQuantity(cartItem.getQuantity() + 1);
        cart.add(cartItem.getProduct(), 1);
        adapter.notifyDataSetChanged();
        adapter.notifyItemRangeChanged(position, cartItemList.size());
        pv = 0;
        price = 0;
        getCartItem(cartItemList);
    }

    @Override
    public void decrease(View view, int position) {
        CartItem cartItem = cartItemList.get(position);
        cartItem.setQuantity(cartItem.getQuantity() - 1);
        cart.remove(cartItem.getProduct(), 1);
        adapter.notifyDataSetChanged();
        adapter.notifyItemRangeChanged(position, cartItemList.size());
        pv = 0;
        price = 0;
        getCartItem(cartItemList);
    }

    @Override
    public void delete(View view, final int position) {
        final int pos = position;
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(getResources().getString(R.string.dialog_title_warning))
                .setContentText(getResources().getString(R.string.dialog_msg_r_u_sure_for_delete))
                .setCancelText(getResources().getString(R.string.dialog_btn_cancel))
                .setConfirmText(getResources().getString(R.string.dialog_btn_ok))
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismiss();
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        cartItemList.get(pos).getProduct().setAdded(false);
                        cart.remove(cartItemList.get(pos).getProduct());
                        cartItemList.remove(pos);
                        adapter.notifyItemRemoved(pos);
                        adapter.notifyItemRangeChanged(pos, cartItemList.size());
                        adapter.notifyDataSetChanged();
                        pv = 0;
                        price = 0;
                        getCartItem(cartItemList);
                        sDialog.setTitleText(getResources().getString(R.string.dialog_msg_delete_completed))
                                .setConfirmText(getResources().getString(R.string.dialog_btn_ok))
                                .setContentText("")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null)
                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                    }
                }).show();
    }
}
