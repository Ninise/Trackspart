package com.ninise.trackspart.mvp.view.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.ninise.trackspart.R;
import com.ninise.trackspart.mvp.model.beans.Rest;
import com.ninise.trackspart.mvp.model.beans.Seconds;
import com.ninise.trackspart.mvp.model.beans.Sets;
import com.ninise.trackspart.mvp.presenter.main.activity.IMainView;
import com.ninise.trackspart.mvp.presenter.main.activity.MainPresenter;
import com.ninise.trackspart.utils.Constants;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

public class MainFragment extends Fragment implements IMainView {

    @Bind(R.id.homeStartButton) Button mGoButton;
    @Bind(R.id.homeTabLay) TableLayout mTableLayout;
    @BindString(R.string.home_sets) String mSetsString;
    @BindString(R.string.home_work) String mSecondsString;
    @BindString(R.string.home_rest) String mRestString;

    private MainPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);

        ButterKnife.bind(this, v);

        setsButtons();
        secsButtons();
        restButtons();

        RxView.clicks(mGoButton).subscribe(
                aVoid -> {
                    mPresenter.startTimer(
                            Sets.getInstance().getCount(),
                            Seconds.getInstance().getCount(),
                            Rest.getInstance().getCount()
                    );
                }
        );

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        changeSetsState(Sets.getInstance().getCount());
        changeSecsState(Seconds.getInstance().getCount());
        changeRestState(Rest.getInstance().getCount());

    }

    public void setsButtons() {
        TableRow setsRow = (TableRow) mTableLayout.getChildAt(0);

        RxView.clicks(setsRow.getChildAt(2)).subscribe(
                aVoid -> {
                    Sets.getInstance().incSets();
                    mPresenter.setSetsState(Sets.getInstance().getCount());
                }
        );

        RxView.clicks(setsRow.getChildAt(0)).subscribe(
                aVoid -> {
                    Sets.getInstance().decSets();
                    mPresenter.setSetsState(Sets.getInstance().getCount());
                }
        );
    }

    public void secsButtons() {
        TableRow secsRow = (TableRow) mTableLayout.getChildAt(1);

        RxView.clicks(secsRow.getChildAt(2)).subscribe(
                aVoid -> {
                    Seconds.getInstance().incSecs();
                    mPresenter.setSecsState(Seconds.getInstance().getCount());
                }
        );

        RxView.clicks(secsRow.getChildAt(0)).subscribe(
                aVoid -> {
                    Seconds.getInstance().decSecs();
                    mPresenter.setSecsState(Seconds.getInstance().getCount());
                }
        );
    }

    public void restButtons() {
        TableRow restRow = (TableRow) mTableLayout.getChildAt(2);

        RxView.clicks(restRow.getChildAt(2)).subscribe(
                aVoid -> {
                    Rest.getInstance().incRest();
                    mPresenter.setRestState(Rest.getInstance().getCount());
                }
        );
        RxView.clicks(restRow.getChildAt(0)).subscribe(
                aVoid -> {
                    Rest.getInstance().decRest();
                    mPresenter.setRestState(Rest.getInstance().getCount());
                }
        );
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void changeSetsState(int state) {
        TableRow setsRow = (TableRow) mTableLayout.getChildAt(0);
        TextView sets = (TextView) setsRow.getChildAt(1);
        sets.setText(mSetsString + " " + state);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void changeSecsState(int state) {
        TableRow secsRow = (TableRow) mTableLayout.getChildAt(1);
        TextView secs = (TextView) secsRow.getChildAt(1);
        secs.setText(mSecondsString + " " + state);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void changeRestState(int state) {
        TableRow restRow = (TableRow) mTableLayout.getChildAt(2);
        TextView rest = (TextView) restRow.getChildAt(1);
        rest.setText(mRestString + " " + state);
    }

    @Override
    public void displayWork() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putInt(Constants.SETS, Sets.getInstance().getCount());
        bundle.putInt(Constants.SECONDS, Seconds.getInstance().getCount());
        bundle.putInt(Constants.REST, Rest.getInstance().getCount());

        TimerFragment fragment = new TimerFragment();
        fragment.setArguments(bundle);

        ft.replace(R.id.mainContainer, fragment);
        ft.commit();
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
