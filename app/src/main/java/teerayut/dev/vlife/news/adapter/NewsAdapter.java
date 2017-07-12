package teerayut.dev.vlife.news.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.news.item.NewsItem;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private OnClickNewsItemListener listener;
    private List<NewsItem> newsItemList = new ArrayList<NewsItem>();
    public NewsAdapter(FragmentActivity activity, List<NewsItem> newsItemList) {
        this.context = activity;
        this.newsItemList = newsItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context) .inflate(R.layout.cardview_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsItem item = newsItemList.get(position);
        Glide.with( context )
                .load( item.getNewsImage() )
                .into( holder.imageView );
        holder.newsTitle.setText(item.getNewsTitle());
        holder.newsExcerpt.setText(item.getNewsDescription());
    }

    @Override
    public int getItemCount() {
        return newsItemList.size();
    }

    public void setOnClickNewsItemListener(OnClickNewsItemListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image_news) ImageView imageView;
        @BindView(R.id.news_title) TextView newsTitle;
        @BindView(R.id.news_excerpt) TextView newsExcerpt;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener( onClickItem() );
        }

        private View.OnClickListener onClickItem() {
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.clickNewsItem(view, getAdapterPosition());
                }
            };
        }
    }

    public interface OnClickNewsItemListener {
        void clickNewsItem(View view, int position);
    }
}
