package teerayut.dev.vlife.cart.payment.detail.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.home.Item.CartItem;

/**
 * Created by teerayut.k on 7/19/2017.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    private Context context;
    private List<CartItem> cartItemList = Collections.emptyList();
    public DetailAdapter(FragmentActivity activity, List<CartItem> cartItemList) {
        this.context = activity;
        this.cartItemList = cartItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context) .inflate(R.layout.cardview_payment_summary, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CartItem item = cartItemList.get(position);
        Glide.with( context )
                .load( item.getProduct().getPRODUCT_IMAGE() )
                .placeholder(R.drawable.no_image)
                .into( holder.thumbs );
        holder.productName.setText(item.getProduct().getName());
        holder.productPV.setText(context.getResources().getString(R.string.title_pv) + " " + item.getProduct().getPRODUCT_PV());
        holder.productPrice.setText(item.getProduct().getPrice() + " " + context.getResources().getString(R.string.price_symbol));
        holder.productAmount.setText(String.valueOf(item.getQuantity()));

        int quantity = item.getQuantity();
        int pv = Integer.parseInt(item.getProduct().getPRODUCT_PV().replace(".00", ""));
        int price = item.getProduct().getPrice().intValue();

        holder.totalPV.setText(String.valueOf(String.format("%,d", (pv * quantity))));
        holder.totalPrice.setText(String.valueOf(String.format("%,d",(price * quantity))
                + " " + context.getResources().getString(R.string.price_symbol)));
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.product_thumbs_list) ImageView thumbs;
        @BindView(R.id.product_name) TextView productName;
        @BindView(R.id.product_pv) TextView productPV;
        @BindView(R.id.product_price) TextView productPrice;
        @BindView(R.id.product_amount) TextView productAmount;
        @BindView(R.id.total_pv) TextView totalPV;
        @BindView(R.id.total_price) TextView totalPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
