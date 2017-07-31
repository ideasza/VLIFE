package teerayut.dev.vlife.profile.point.clam_history.adapter;

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
import teerayut.dev.vlife.profile.point.clam_history.item.ClamItem;

/**
 * Created by teerayut.k on 7/31/2017.
 */

public class ClamHistoryAdapter extends RecyclerView.Adapter<ClamHistoryAdapter.ViewHolder> {

    private Context context;
    private List<ClamItem> clamItems = new ArrayList<ClamItem>();
    public ClamHistoryAdapter(FragmentActivity activity, List<ClamItem> clamItems) {
        this.context = activity;
        this.clamItems = clamItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context) .inflate(R.layout.cardview_point_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClamItem item = clamItems.get(position);
        holder.orderNumber.setText(item.getClamDate());
        holder.orderDate.setText(item.getClamDetail());
        holder.orderType.setText(item.getClamStatus());
        holder.orderPoints.setText(String.valueOf(String.format("%,d", Integer.parseInt(item.getClamPoints()))));
    }

    @Override
    public int getItemCount() {
        return clamItems.size();
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
