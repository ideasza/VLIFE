package teerayut.dev.vlife.profile.order_history.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.profile.order_history.item.OrderHistoryItem;

/**
 * Created by teerayut.k on 7/16/2017.
 */

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder> {

    private Context context;
    private List<OrderHistoryItem> orderHistoryItemList = new ArrayList<OrderHistoryItem>();
    public OrderHistoryAdapter(FragmentActivity activity, List<OrderHistoryItem> orderHistoryItemList) {
        this.context = activity;
        this.orderHistoryItemList = orderHistoryItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context) .inflate(R.layout.cardview_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OrderHistoryItem item = orderHistoryItemList.get(position);
        holder.orderNumber.setText(context.getResources().getString(R.string.history_title_number) + "\n" + item.getOrderNumber());
        holder.orderDate.setText(item.getOrderDate());
        holder.memberCode.setText(context.getResources().getString(R.string.member_code) + ": " + item.getMemberCode());
        holder.orderType.setText(context.getResources().getString(R.string.title_bil_type) + ": " + item.getOrderType());
        holder.productPrice.setText(context.getResources().getString(R.string.title_sum_total) + ": "
                + String.valueOf(String.format("%,d", Integer.parseInt(item.getPrice()))));
        holder.productPv.setText(context.getResources().getString(R.string.title_sum_point) + ": "
                + String.valueOf(String.format("%,d", Integer.parseInt(item.getPv()))));
    }

    @Override
    public int getItemCount() {
        return orderHistoryItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.order_number) TextView orderNumber;
        @BindView(R.id.order_date) TextView orderDate;
        @BindView(R.id.member_code) TextView memberCode;
        @BindView(R.id.order_type) TextView orderType;
        @BindView(R.id.product_price) TextView productPrice;
        @BindView(R.id.product_pv) TextView productPv;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
