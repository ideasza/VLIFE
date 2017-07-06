package teerayut.dev.vlife.fragment.product;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends BaseMvpFragment<ProductInterface.Presenter> implements ProductInterface.View {


    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public ProductInterface.Presenter createPresenter() {
        return ProductPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.fragment_product;
    }

    @Override
    public void bindView(View view) {

    }

    @Override
    public void setupInstance() {

    }

    @Override
    public void setupView() {

    }

    @Override
    public void initialize() {

    }

}
