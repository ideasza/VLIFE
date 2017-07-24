package teerayut.dev.vlife.profile.point.point_history.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.profile.point.point_history.item.PointItem;

/**
 * Created by teerayut.k on 7/24/2017.
 */

public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ViewHolder> {

    private Context context;
    private List<PointItem> pointItems = new ArrayList<PointItem>();
    public PointAdapter(FragmentActivity activity, List<PointItem> pointItems) {
        this.context = activity;
        this.pointItems = pointItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context) .inflate(R.layout.cardview_point_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PointItem item = pointItems.get(position);
        holder.orderNumber.setText(context.getResources().getString(R.string.history_title_number) + "\n" + item.getOrderNumber());
        holder.orderDate.setText(item.getOrderDate());
        holder.orderType.setText(item.getPointType());
        holder.orderPoints.setText(String.valueOf(String.format("%,d", Integer.parseInt(item.getPoint()))));
    }

    @Override
    public int getItemCount() {
        return pointItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.order_number) TextView orderNumber;
        @BindView(R.id.order_date) TextView orderDate;
        @BindView(R.id.type) TextView orderType;
        @BindView(R.id.points) TextView orderPoints;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
