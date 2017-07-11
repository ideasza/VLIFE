package teerayut.dev.vlife.fragment.home.adapter;

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
import teerayut.dev.vlife.fragment.home.Item.ProductItem;

/**
 * Created by teerayut.k on 7/9/2017.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private Context context;
    private OnClickListener listener;
    private List<ProductItem> itemModelList = new ArrayList<ProductItem>();
    public HomeAdapter(FragmentActivity activity, List<ProductItem> itemModels) {
        this.context = activity;
        this.itemModelList = itemModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context) .inflate(R.layout.cardview_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductItem item = itemModelList.get(position);
        holder.textViewName.setText(item.getName());
        holder.textViewPv.setText(context.getResources().getString(R.string.title_pv) + " " + item.getPv());
        holder.textViewPrice.setText(item.getPrice() + " " + context.getResources().getString(R.string.price_symbol));

        Glide.with( context )
                .load( item.getImage() )
                .into( holder.imageViewProduct );

        holder.setOnClickItemListener(onClick(item));

        if( item.isAdded() ){
            holder.buttonAdded.setVisibility( View.VISIBLE );
            holder.buttonAdd.setVisibility( View.GONE );
        }else{
            holder.buttonAdded.setVisibility( View.GONE );
            holder.buttonAdd.setVisibility( View.VISIBLE );
        }
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public interface  OnClickListener {
        void onClickAdded(ProductItem item, int position);
        void onClickAddToCart(ProductItem item, int position);
    }

    private ViewHolder.OnClickItemListener onClick(final ProductItem item) {
        return new ViewHolder.OnClickItemListener() {
            @Override
            public void onClickAddToCart(ViewHolder view, int position) {
                item.setAdded( true );
                if( listener != null ){
                    listener.onClickAddToCart( item, position );
                }
            }

            @Override
            public void onClickAdded(ViewHolder view, int position) {
                item.setAdded( false );
                if( listener != null ){
                    listener.onClickAdded( item, position );
                }
            }
        };
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private OnClickItemListener listener;

        @BindView(R.id.product_image) ImageView imageViewProduct;
        @BindView(R.id.product_name) TextView textViewName;
        @BindView(R.id.product_pv) TextView textViewPv;
        @BindView(R.id.product_price) TextView textViewPrice;
        @BindView(R.id.btn_add_to_cart) Button buttonAdd;
        @BindView(R.id.btn_added) Button buttonAdded;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            buttonAdd.setOnClickListener( onClickAddToCart() );
            buttonAdded.setOnClickListener( onClickAdded() );
        }

        public void setOnClickItemListener(OnClickItemListener listener) {
            this.listener = listener;
        }

        public interface OnClickItemListener {
            void onClickAddToCart(ViewHolder view, int position );
            void onClickAdded(ViewHolder view, int position );
        }

        private void toggleButton(){
            if( buttonAdd.getVisibility() == View.VISIBLE ){
                buttonAdded.setVisibility( View.VISIBLE );
                buttonAdd.setVisibility( View.GONE );
            }else{
                buttonAdded.setVisibility( View.GONE );
                buttonAdd.setVisibility( View.VISIBLE );
            }
        }

        @NonNull
        private View.OnClickListener onClickAdded(){
            return new View.OnClickListener(){
                @Override
                public void onClick( View v ){
                    if( listener != null ){
                        listener.onClickAdded( ViewHolder.this, getAdapterPosition() );
                    }
                    toggleButton();
                }
            };
        }

        @NonNull
        private View.OnClickListener onClickAddToCart(){
            return new View.OnClickListener(){
                @Override
                public void onClick( View v ){
                    if( listener != null ){
                        listener.onClickAddToCart( ViewHolder.this, getAdapterPosition() );
                    }
                    toggleButton();
                }
            };
        }
    }



}
