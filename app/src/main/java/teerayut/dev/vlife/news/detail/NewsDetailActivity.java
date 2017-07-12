package teerayut.dev.vlife.news.detail;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.news.item.NewsItem;
import teerayut.dev.vlife.utils.Config;

public class NewsDetailActivity extends AppCompatActivity {

    private NewsItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        bindView();
    }

    @BindView(R.id.news_title) TextView newsTitle;
    @BindView(R.id.news_description) TextView newsDesc;
    @BindView(R.id.detail_image) ImageView img;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private void bindView() {
        ButterKnife.bind(this);
        getDataIntent();
        setToolbar();
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void getDataIntent() {
        item = (NewsItem) getIntent().getSerializableExtra(Config.KEY_NEWS_ITEM_DETAIL);
        toolbar.setTitle("");
        Glide.with( this )
                .load( item.getNewsImage() )
                .into( img );

        newsTitle.setText(item.getNewsTitle());

        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(item.getNewsDescription());

        newsDesc.setText(sb.toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            setResult(RESULT_CANCELED);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
