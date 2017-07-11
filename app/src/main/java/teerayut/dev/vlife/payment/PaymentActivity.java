package teerayut.dev.vlife.payment;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bit.szw.widget.StepView;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.payment.adapter.ViewPagerAdapter;
import teerayut.dev.vlife.utils.AnimateButton;

public class PaymentActivity extends AppCompatActivity {

    private int currentPage = 0;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        bindView();
        setView();
    }

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.stepview) StepView stepView;
    @BindView(R.id.pager) ViewPager pager;
    @BindView(R.id.button_next) Button buttonNext;
    private void bindView() {
        ButterKnife.bind(this);
    }

    private void setView() {
        setToolbar();
        setIntance();
        setStepView(1);
        buttonNext.setOnClickListener( onNext() );
    }

    private void setToolbar() {
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
        stepView.setDrawableSize(38);
        stepView.setCurrentStep(page);
        stepView.setLineHeight(4);
        stepView.setCurrentDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_brightness_1_white_36dp));
        stepView.setDrawable(getResources().getDrawable(R.drawable.ic_brightness_1_white_36dp));
        stepView.setLineColor(getResources().getColor(R.color.colorAccent2));
        stepView.setReachedLineColor(getResources().getColor(R.color.colorAccent2));
        stepView.setReachedDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_check_circle_white_36dp));
        stepView.setUnreachedLineColor(getResources().getColor(R.color.colorAccent2));
        stepView.setUnreachedDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_panorama_fish_eye_white_36dp));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            setResult(RESULT_CANCELED);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener onNext() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonNext.startAnimation(new AnimateButton().animbutton());
                currentPage = pager.getCurrentItem() + 1;
                pager.setCurrentItem(currentPage);
                stepView.setCurrentStep(currentPage + 1);
                Log.e("Page selected", currentPage + "");
            }
        };
    }
}
