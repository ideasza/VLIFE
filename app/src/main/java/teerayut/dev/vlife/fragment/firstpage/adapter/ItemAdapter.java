package teerayut.dev.vlife.fragment.firstpage.adapter;

import android.view.ViewGroup;

import teerayut.dev.vlife.base.adapter.BaseViewHolder;
import teerayut.dev.vlife.base.adapter.loadmore.LoadmoreAdapter;

/**
 * Created by teerayut.k on 7/6/2017.
 */

public class ItemAdapter extends LoadmoreAdapter<BaseViewHolder, ItemAdapterInterface.Presenter>
        implements ItemAdapterInterface.Adapter{
    private final static String TAG = ItemAdapter.class.getSimpleName();

    public static final int TYPE_PRODUCT = 0;

    @Override
    public ItemAdapterInterface.Presenter createPresenter() {
        return ItemAdapterPresenter.create();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }
}
