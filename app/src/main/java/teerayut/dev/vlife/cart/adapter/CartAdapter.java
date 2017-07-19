package teerayut.dev.vlife.cart.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.home.Item.CartItem;

/**
 * Created by teerayut.k on 7/11/2017.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private Context context;
    private ClickListener clickListener;
    private List<CartItem> cartItemList = Collections.emptyList();
    public CartAdapter(Context context, List<CartItem> cartItemList) {
        this.context = context;
        this.cartItemList = cartItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context) .inflate(R.layout.cardview_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CartItem cartItem = cartItemList.get(position);
        holder.textViewProductName.setText(cartItem.getProduct().getName());
        holder.textViewProductPV.setText(context.getResources().getString(R.string.title_pv) + ": " + cartItem.getProduct().getPv());

        int price = Integer.parseInt(cartItem.getProduct().getPrice() + "");

        holder.textViewProductPrice.setText(String.valueOf(String.format("%,d", price)) + " " + context.getResources().getString(R.string.price_symbol));
        holder.textViewProductAmount.setText(String.valueOf(cartItem.getQuantity()));

        if (cartItem.getQuantity() == 1) {
            holder.desrease.setEnabled(false);
            holder.desrease.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_decrease_disable_36dp));
        } else {
            holder.desrease.setEnabled(true);
            holder.desrease.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_decrease_normal_36dp));
        }
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.product_name) TextView textViewProductName;
        @BindView(R.id.product_pv) TextView textViewProductPV;
        @BindView(R.id.product_price) TextView textViewProductPrice;
        @BindView(R.id.btn_decrease) ImageView desrease;
        @BindView(R.id.btn_increase) ImageView increase;
        @BindView(R.id.btn_delete) ImageView delete;
        @BindView(R.id.product_amount) TextView textViewProductAmount;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            desrease.setOnClickListener( onDecrease() );
            increase.setOnClickListener( onIncrease() );
            delete.setOnClickListener( onDelete() );
        }

        private View.OnClickListener onDecrease() {
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.decrease(view, getPosition());
                }
            };
        }

        private View.OnClickListener onIncrease() {
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.increase(view, getPosition());
                }
            };
        }

        private View.OnClickListener onDelete() {
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.delete(view, getPosition());
                }
            };
        }
    }

    public interface ClickListener{
        public void increase(View view, int position);
        public void decrease(View view, int position);
        public void delete(View view, int position);
    }
}
