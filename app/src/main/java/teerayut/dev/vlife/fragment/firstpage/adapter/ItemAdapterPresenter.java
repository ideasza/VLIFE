package teerayut.dev.vlife.fragment.firstpage.adapter;

import teerayut.dev.vlife.base.adapter.loadmore.LoadmoreAdapterPresenter;
import teerayut.dev.vlife.fragment.firstpage.item.Item;

/**
 * Created by teerayut.k on 7/6/2017.
 */

public class ItemAdapterPresenter extends LoadmoreAdapterPresenter<ItemAdapterInterface.Adapter>
        implements ItemAdapterInterface.Presenter{

    public static ItemAdapterInterface.Presenter create(){
        return new ItemAdapterPresenter();
    }

    @Override
    public void clearAddState(Item item) {

    }

    @Override
    public void clearAddStateAll() {

    }
}
