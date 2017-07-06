package teerayut.dev.vlife.fragment.firstpage.holder;

import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import teerayut.dev.vlife.base.adapter.BaseViewHolder;

/**
 * Created by teerayut.k on 7/6/2017.
 */

public class ItemHolder extends BaseViewHolder {
    public ItemHolder(ViewGroup parent, int layout) {
        super(parent, layout);
    }

    @Override
    public void bindView(View view) {
        ButterKnife.bind(this, view);
    }
}
