package teerayut.dev.vlife.forget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.base.BaseMvpActivity;

public class ForgetActivity extends BaseMvpActivity<ForgetInterface.Presenter> implements ForgetInterface.View {

    @Override
    public ForgetInterface.Presenter createPresenter() {
        return ForgetPresenter.create();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_forget;
    }

    @BindView(R.id.toolbar) Toolbar toolbar;
    @Override
    public void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    public void setupInstance() {

    }

    @Override
    public void setupView() {
        setToolbar();
    }

    @Override
    public void initialize() {

    }

    private void setToolbar() {
        toolbar.setTitle(getResources().getString(R.string.forgetpassword));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            setResult(RESULT_CANCELED);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
