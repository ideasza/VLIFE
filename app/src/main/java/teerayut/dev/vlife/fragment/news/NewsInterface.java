package teerayut.dev.vlife.fragment.news;

import teerayut.dev.vlife.base.BaseMvpInterface;

/**
 * Created by OzoeSK on 7/6/2017.
 */

public class NewsInterface {

    public interface View extends BaseMvpInterface.View {

    }

    public interface Presenter extends BaseMvpInterface.Presenter<NewsInterface.View> {

    }
}
