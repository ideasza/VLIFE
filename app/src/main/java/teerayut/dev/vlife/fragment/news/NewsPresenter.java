package teerayut.dev.vlife.fragment.news;

import teerayut.dev.vlife.base.BaseMvpPresenter;

/**
 * Created by OzoeSK on 7/6/2017.
 */

public class NewsPresenter extends BaseMvpPresenter<NewsInterface.View> implements NewsInterface.Presenter {

    public static NewsInterface.Presenter create() {
        return new NewsPresenter();
    }
}
