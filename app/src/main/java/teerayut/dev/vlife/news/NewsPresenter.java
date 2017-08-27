package teerayut.dev.vlife.news;

import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.base.BaseMvpPresenter;
import teerayut.dev.vlife.news.item.NewsItem;
import teerayut.dev.vlife.utils.Config;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public class NewsPresenter extends BaseMvpPresenter<NewsInterface.View> implements NewsInterface.Presenter {

    private NewsItem item;
    private List<NewsItem> newsItemList = new ArrayList<NewsItem>();

    public static NewsInterface.Presenter create() {
        return new NewsPresenter();
    }

    @Override
    public void requestNews() {
        newsItemList.clear();

        item = new NewsItem();
        item.setNewsTitle("LOREM IPSUM DOLOR SIT AMET");
        item.setNewsDescription("Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum");
        item.setNewsImage(Config.NEWS_URL_1);
        newsItemList.add(item);

        item = new NewsItem();
        item.setNewsTitle("LOREM IPSUM DOLOR SIT AMET");
        item.setNewsDescription("Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum");
        item.setNewsImage(Config.NEWS_URL_2);
        newsItemList.add(item);

        item = new NewsItem();
        item.setNewsTitle("LOREM IPSUM DOLOR SIT AMET");
        item.setNewsDescription("Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum");
        item.setNewsImage(Config.NEWS_URL_3);
        newsItemList.add(item);

        item = new NewsItem();
        item.setNewsTitle("LOREM IPSUM DOLOR SIT AMET");
        item.setNewsDescription("Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum");
        item.setNewsImage(Config.NEWS_URL_4);
        newsItemList.add(item);

        item = new NewsItem();
        item.setNewsTitle("LOREM IPSUM DOLOR SIT AMET");
        item.setNewsDescription("Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum");
        item.setNewsImage(Config.NEWS_URL_5);
        newsItemList.add(item);

        item = new NewsItem();
        item.setNewsTitle("LOREM IPSUM DOLOR SIT AMET");
        item.setNewsDescription("Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum Lorem ipsum dolor sit amet sectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt Lorem ipsum");
        item.setNewsImage(Config.NEWS_URL_1);
        newsItemList.add(item);

        getView().setItemToRecyclerView(newsItemList);
    }
}
