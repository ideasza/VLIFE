package teerayut.dev.vlife.cart.payment;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bit.szw.widget.StepView;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpActivity;
import teerayut.dev.vlife.cart.payment.adapter.ViewPagerAdapter;
import teerayut.dev.vlife.cart.payment.delivery.DeliveryFragment;
import teerayut.dev.vlife.cart.payment.detail.DetailFragment;
import teerayut.dev.vlife.cart.payment.pay.PayFragment;

public class PaymentActivity extends BaseMvpActivity<PaymentInterface.Presenter> implements PaymentInterface.View, DeliveryFragment.onClickButtonNext,
        DetailFragment.onClickButtonNext, PayFragment.onClickButtonNext {

    private int currentPage = 0;
    private ViewPagerAdapter adapter;

    @Override
    public PaymentInterface.Presenter createPresenter() {
        return PaymentPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_payment;
    }

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.stepview) StepView stepView;
    @BindView(R.id.pager) ViewPager pager;
    @Override
    public void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    public void setupInstance() {

    }

    @Override
    public void setupView() {
        setView();
    }

    @Override
    public void initialize() {

    }

    private void setView() {
        setToolbar();
        setIntance();
        setStepView(1);
    }

    private void setToolbar() {
        toolbar.setTitle(getResources().getString(R.string.title_deliver));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setIntance() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setStepView(position + 1);
                switch (position) {
                    case 0 :
                        toolbar.setTitle(getResources().getString(R.string.title_deliver));
                        break;
                    case 1 :
                        toolbar.setTitle(getResources().getString(R.string.title_detail));
                        break;
                    case 2 :
                        toolbar.setTitle(getResources().getString(R.string.title_pay));
                        break;
                    case 3 :
                        toolbar.setTitle(getResources().getString(R.string.title_summary));
                        break;
                    default:
                        toolbar.setTitle(getResources().getString(R.string.title_deliver));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setStepView(int page) {
        List<String> lables = new ArrayList<>();
        lables.add("");
        lables.add("");
        lables.add("");
        stepView.setStepText(lables);
        stepView.setVerticalSpace(5);
        stepView.setDrawableSize(40);
        stepView.setCurrentStep(page);
        stepView.setLineHeight(4);
        stepView.setCurrentDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.step_current));
        stepView.setDrawable(getResources().getDrawable(R.drawable.step_current));
        stepView.setLineColor(getResources().getColor(R.color.colorAccent2));
        stepView.setReachedLineColor(getResources().getColor(R.color.colorAccent2));
        stepView.setReachedDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_check_circle_white_48dp));
        stepView.setUnreachedLineColor(getResources().getColor(R.color.DarkGray));
        stepView.setUnreachedDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.step_unreached));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if(pager.getCurrentItem() > 0) {
                pager.setCurrentItem(pager.getCurrentItem() - 1);
                if (pager.getCurrentItem() < 3) {
                    stepView.setVisibility(View.VISIBLE);
                }
            } else {
                setResult(RESULT_CANCELED);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnClickButtonNext(View view) {
        switch (view.getId()) {
            case R.id.button_delivery_next :
                getPresenter().nextViewPager(pager.getCurrentItem());
                break;
            case R.id.button_detail_next :
                getPresenter().nextViewPager(pager.getCurrentItem());
                break;
            case R.id.button_pay_next :
                getPresenter().nextViewPager(pager.getCurrentItem());
                break;
        }
    }

    @Override
    public void onNextViewPager(int number) {
        pager.setCurrentItem(number);
        if (number == 3) {
            stepView.setVisibility(View.GONE);
        } else {
            stepView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onGoToSummaryPage() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            if(pager.getCurrentItem() > 0) {
                pager.setCurrentItem(pager.getCurrentItem() - 1);
                if (pager.getCurrentItem() < 3) {
                    stepView.setVisibility(View.VISIBLE);
                }
                return true;
            } else {
                setResult(RESULT_CANCELED);
                finish();
                return true;
            }
        }
        return false;
    }
}
