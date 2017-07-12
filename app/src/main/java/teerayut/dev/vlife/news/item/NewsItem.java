package teerayut.dev.vlife.news.item;

import com.android.tonyvu.sc.model.Saleable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by teerayut.k on 7/12/2017.
 */

public class NewsItem implements Saleable, Serializable {
    private static final long serialVersionUID = -4073256626483275668L;

    private String newsTitle;
    private String newsDescription;
    private String newsImage;

    public NewsItem() {
        super();
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
