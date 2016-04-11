package com.ninise.trackspart.mvp.view.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.ninise.trackspart.R;
import com.ninise.trackspart.mvp.presenter.IStateView;
import com.ninise.trackspart.mvp.presenter.main.fragment.ITimerView;
import com.ninise.trackspart.mvp.presenter.main.fragment.TimerPresenter;
import com.ninise.trackspart.utils.Constants;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

public class TimerFragment extends Fragment implements ITimerView, IStateView {

    @Bind(R.id.timerSets) TextView mSetsTextView;
    @Bind(R.id.timerSeconds) TextView mSecondsTextView;
    @Bind(R.id.timerRest) TextView mRestTextView;
    @Bind(R.id.progress_view) CircularProgressView mCircularProgressView;
    @Bind(R.id.timerState) TextView mStateTextView;
    @BindString(R.string.timer_state_work) String mWork;
    @BindString(R.string.timer_state_rest) String mRest;

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

        mPresenter.startTimer(
                getArguments().getInt(Constants.SETS),
                getArguments().getInt(Constants.SECONDS),
                getArguments().getInt(Constants.REST)
        );

        mCircularProgressView.startAnimation();

        return v;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void changeSetsState(int state) {
        mSetsTextView.setText(Constants.SETS + ": " + state);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void changeSecsState(int state) {
        mCircularProgressView.setProgress(state);
        mSecondsTextView.setText(Constants.SECONDS + ": " + state);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void changeRestState(int state) {
        mCircularProgressView.setProgress(state);
        mRestTextView.setText(Constants.REST + ": " + state);
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    @Override
    public void onSecs() {
        mCircularProgressView.setMaxProgress(getArguments().getInt(Constants.SECONDS));
        mCircularProgressView.setColor(getActivity().getResources().getColor(R.color.colorPrimaryDark));
        mStateTextView.setText(mWork);
    }

    @Override
    public void onRest() {
        mCircularProgressView.setMaxProgress(getArguments().getInt(Constants.REST));
        mCircularProgressView.setColor(getActivity().getResources().getColor(R.color.justGreen));
        mStateTextView.setText(mRest);
    }

    @Override
    public void onStopTimer() {
        mCircularProgressView.setProgress(0);
        mCircularProgressView.stopAnimation();
    }

    @Override
    public void backToMain() {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainContainer, new MainFragment());
        fragmentTransaction.commit();
    }
}
