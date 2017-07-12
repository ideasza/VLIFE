package teerayut.dev.vlife.news;

import java.util.List;

import teerayut.dev.vlife.news.item.NewsItem;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public interface NewsInterface {

    public interface View {
        void setItemToRecyclerView(List<NewsItem> modelList);
        void showUnvailable();
        void showAvailable();
    }

    public interface Presenter {
        void requestNews();
    }
}
