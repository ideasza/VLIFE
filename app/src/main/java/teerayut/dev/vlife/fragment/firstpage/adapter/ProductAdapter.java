package teerayut.dev.vlife.fragment.firstpage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.fragment.firstpage.item.Item;

/**
 * Created by teerayut.k on 7/7/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private OnProductClickListener listener;
    private List<Item> items = new ArrayList<Item>();
    public ProductAdapter(FragmentActivity activity, List<Item> itemList) {
        this.context = activity;
        this.items = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context) .inflate(R.layout.cardview_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.textViewName.setText(item.getName());
        holder.textViewPv.setText(context.getResources().getString(R.string.title_pv) + " " + item.getPv());
        holder.textViewPrice.setText(item.getPrice() + " " + context.getResources().getString(R.string.price_symbol));

        Glide.with( context )
                .load( item.getImage() )
                .into( holder.imageViewProduct );

        if( item.isAdded() ){
            holder.buttonAdded.setVisibility( View.VISIBLE );
            holder.buttonAdd.setVisibility( View.GONE );
        }else{
            holder.buttonAdded.setVisibility( View.GONE );
            holder.buttonAdd.setVisibility( View.VISIBLE );
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnClickProductItem( OnProductClickListener listener ){
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements ProductAdapter.OnProductClickListener {

        @BindView(R.id.product_image) ImageView imageViewProduct;
        @BindView(R.id.product_name) TextView textViewName;
        @BindView(R.id.product_pv) TextView textViewPv;
        @BindView(R.id.product_price) TextView textViewPrice;
        @BindView(R.id.btn_add_to_cart) Button buttonAdd;
        @BindView(R.id.btn_added) Button buttonAdded;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @Override
        public void onClickItem(Context item, int position) {
            if( listener != null ){
                listener.onClickItem( context, getAdapterPosition() );
            }
        }

        @Override
        public void onClickAddToCart(Context item, int position) {
            if( listener != null ){
                listener.onClickAddToCart( context, getAdapterPosition() );
            }
            //toggleButton();
        }

        @Override
        public void onClickAdded(Context item, int position) {
            if( listener != null ){
                listener.onClickAdded( context, getAdapterPosition() );
            }
            //toggleButton();
        }
    }

    public interface OnProductClickListener{
        void onClickItem(Context item, int position );

        void onClickAddToCart(Context item, int position );

        void onClickAdded(Context item, int position );
    }
}
