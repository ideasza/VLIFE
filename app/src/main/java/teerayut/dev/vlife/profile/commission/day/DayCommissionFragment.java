package teerayut.dev.vlife.profile.commission.day;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import com.borax12.materialdaterangepicker.time.TimePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import teerayut.dev.vlife.R;
import teerayut.dev.vlife.main.MainActivity;
import teerayut.dev.vlife.utils.Config;
import teerayut.dev.vlife.utils.DateRangePickerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DayCommissionFragment extends Fragment
        implements DayCommissionInterface.View, DateRangePickerFragment.OnDateRangeSelectedListener {


    public DayCommissionFragment() {
        // Required empty public constructor
    }

    public static DayCommissionFragment newInstance() {
        return new DayCommissionFragment();
    }

    private View view;
    private DayCommissionInterface.Presenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day_commission, container, false);
        bindView();
        return view;
    }

    @BindView(R.id.recyclerview) RecyclerView recyclerView;
    @BindView(R.id.fab) FloatingActionButton dateRangeButton;
    @BindView(R.id.container_service_unavailable) FrameLayout containerUnvailable;
    private void bindView() {
        ButterKnife.bind(this, view);
        setInstance();
        setView();
    }

    private void setInstance() {
        presenter = new DayCommissionPresenter(this);
        dateRangeButton.setOnClickListener( onDateDialog() );
    }

    private void setView() {
        StaggeredGridLayoutManager layout = new StaggeredGridLayoutManager( Config.COLUMN_ONE, StaggeredGridLayoutManager.VERTICAL );
        recyclerView.setLayoutManager( layout );
    }

    @Override
    public void showUnvailable() {
        recyclerView.setVisibility( View.GONE );
        containerUnvailable.setVisibility( View.VISIBLE );
    }

    @Override
    public void showAvailable() {
        recyclerView.setVisibility( View.VISIBLE );
        containerUnvailable.setVisibility( View.GONE );
    }

    private View.OnClickListener onDateDialog() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DateRangePickerFragment dateRangePickerFragment= DateRangePickerFragment.newInstance(onDateSetListener, false);
                //dateRangePickerFragment.show(getFragmentManager(),"datePicker");
            }
        };
    }

    private Calendar calendar;
    private DatePickerDialog.OnDateSetListener onDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {

                }
            };

    @Override
    public void onDateRangeSelected(int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) {

    }
}
