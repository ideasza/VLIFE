package teerayut.dev.vlife.register;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bit.szw.widget.StepView;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.register.adapter.ViewPagerAdapter;
import teerayut.dev.vlife.register.address.RegisterAddressFragment;
import teerayut.dev.vlife.register.register_main.RegisterMainFragment;
import teerayut.dev.vlife.register.register_partner.RegisterPartnerFragment;
import teerayut.dev.vlife.register.sending_address.RegisterSendingAddressFragment;

public class RegisterActivity extends AppCompatActivity implements RegisterInterface.View, RegisterMainFragment.onClickButtonNext,
        RegisterPartnerFragment.onClickButtonNext, RegisterAddressFragment.onClickButtonNext, RegisterSendingAddressFragment.onClickButtonNext{

    private ViewPagerAdapter adapter;
    private RegisterInterface.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bindView();
    }

    @BindView(R.id.stepview) StepView stepView;
    @BindView(R.id.pager) ViewPager viewPager;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private void bindView() {
        ButterKnife.bind(this);
        setToolbar();
        setInstance();
        setStepView(1);
        presenter = new RegisterPresenter(this);
    }

    private void setToolbar() {
        toolbar.setTitle(getResources().getString(R.string.main_menu_register));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setInstance() {

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                /*Log.e("Scrolled", "postion : " + position);
                if (position == 3) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                }*/
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
        lables.add("");
        stepView.setStepText(lables);
        stepView.setVerticalSpace(5);
        stepView.setDrawableSize(38);
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
            if(viewPager.getCurrentItem() > 0) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
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
            case R.id.button_main_next :
                presenter.nextViewPager(viewPager.getCurrentItem());
                break;
            case R.id.button_partner_next :
                presenter.nextViewPager(viewPager.getCurrentItem());
                break;
            case R.id.button_address_next :
                presenter.nextViewPager(viewPager.getCurrentItem());
                break;
            case R.id.button_sending_address_next :
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)){
            if(viewPager.getCurrentItem() > 0) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                return true;
            } else {
                setResult(RESULT_CANCELED);
                finish();
                return true;
            }
        }
        return false;
    }

    @Override
    public void onNextViewPager(int number) {
        viewPager.setCurrentItem(number);
    }
}
