package teerayut.dev.vlife.fragment.firstpage.adapter;

import teerayut.dev.vlife.base.adapter.loadmore.LoadmoreAdapterInterface;
import teerayut.dev.vlife.fragment.firstpage.item.Item;

/**
 * Created by teerayut.k on 7/6/2017.
 */

public class ItemAdapterInterface {

    public interface Adapter extends LoadmoreAdapterInterface.Adapter{
    }

    public interface Presenter extends LoadmoreAdapterInterface.Presenter<ItemAdapterInterface.Adapter>{
        void clearAddState( Item item );
        void clearAddStateAll();
    }
}
