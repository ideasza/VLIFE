package teerayut.dev.vlife.cart.payment.detail;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.tonyvu.sc.model.Cart;
import com.android.tonyvu.sc.util.CartHelper;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.home.Item.CartItem;
import teerayut.dev.vlife.cart.payment.detail.adapter.DetailAdapter;
import teerayut.dev.vlife.utils.ExtactCartItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private int sumPV = 0;
    private int sumPrice = 0;
    private DetailAdapter adapter;
    private Cart cart = CartHelper.getCart();
    private List<CartItem> cartItemList = Collections.emptyList();

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        bindView(view);
        return view;
    }

    private onClickButtonNext clickButtonNext;
    @BindView(R.id.sumTitle) TextView textViewSumTitle;
    @BindView(R.id.sumValues) TextView textViewSumValus;
    @BindView(R.id.button_detail_next) Button buttonNext;
    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    private void bindView(View view) {
        ButterKnife.bind(this, view);
        setView();
        buttonNext.setOnClickListener( onNext() );
        setListItem();
    }

    private void setListItem() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        prepareItem();
    }

    private void setView() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(getResources().getString(R.string.title_sum_point) + "\n");
        sb1.append(getResources().getString(R.string.title_sum_total) + "\n");
        sb1.append(getResources().getString(R.string.title_send) + "\n");
        sb1.append(getResources().getString(R.string.title_net_price));
        textViewSumTitle.setText(sb1.toString());
    }

    private void prepareItem() {
        StringBuilder sb2 = new StringBuilder();
        cartItemList = new ExtactCartItem().getCartItems(cart);
        if (cartItemList.size() > 0) {
            adapter = new DetailAdapter(getActivity(), cartItemList);
            recyclerView.setAdapter(adapter);
            for (CartItem item : cartItemList) {
                int quantity = item.getQuantity();
                int pv = Integer.parseInt(item.getProduct().getPv());
                int price = Integer.parseInt(item.getProduct().getPrice() + "");
                sumPV += (pv * quantity);
                sumPrice += (price * quantity);
            }
            sb2.append(String.valueOf(String.format("%,d", sumPV)) + "\n");
            sb2.append(String.valueOf(String.format("%,d", sumPrice)) + " " + getResources().getString(R.string.price_symbol) + "\n");
            sb2.append("0" + " " + getResources().getString(R.string.price_symbol) + "\n");
            sb2.append(String.valueOf(String.format("%,d", sumPrice))  + " " + getResources().getString(R.string.price_symbol));
            textViewSumValus.setText(sb2.toString());
        } else {
            sb2.append("0" + "\n");
            sb2.append("0" + " " + getResources().getString(R.string.price_symbol) + "\n");
            sb2.append("0" + " " +  getResources().getString(R.string.price_symbol) +  "\n");
            sb2.append("0" + " " +  getResources().getString(R.string.price_symbol));
            textViewSumValus.setText(sb2.toString());
        }
    }

    private View.OnClickListener onNext() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickButtonNext.OnClickButtonNext(view);
            }
        };
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            clickButtonNext = (onClickButtonNext) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(((Activity) context).getLocalClassName()
                    + " DetailFragment implement OnButtonClickListener");
        }
    }

    public interface onClickButtonNext{
        void OnClickButtonNext(View view);
    }
}
