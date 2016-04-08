package com.ninise.trackspart.mvp.view.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ninise.trackspart.R;
import com.ninise.trackspart.mvp.presenter.IStateView;
import com.ninise.trackspart.mvp.presenter.main.fragment.TimerPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TimerFragment extends Fragment implements IStateView {

    @Bind(R.id.timerSets) TextView mSetsTextView;
    @Bind(R.id.timerSeconds) TextView mSecondsTextView;
    @Bind(R.id.timerRest) TextView mRestTextView;

    private TimerPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new TimerPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.timer_fragment, container, false);

        ButterKnife.bind(this , v);

        mPresenter.startTimer(2, 10, 2);

        return v;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void changeSetsState(int state) {
        mSetsTextView.setText("Sets " + state);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void changeSecsState(int state) {
        mSecondsTextView.setText("Secs " + state);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void changeRestState(int state) {
        mRestTextView.setText("Rest " + state);
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
