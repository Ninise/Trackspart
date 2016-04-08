package com.ninise.trackspart.mvp.presenter.main.fragment;

import com.ninise.trackspart.mvp.model.timer.SecondsTimer;
import com.ninise.trackspart.mvp.presenter.IStateView;

import rx.android.schedulers.AndroidSchedulers;

public class TimerPresenter implements ITimerPresenter {

    private IStateView mView;

    public TimerPresenter(IStateView view) {
        mView = view;
    }

    @Override
    public void startTimer(int sets, int seconds, int rest) {
        SecondsTimer.startSecondsTimer(seconds)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(num -> {
            mView.changeSetsState(sets);
            mView.changeSecsState(num.intValue());
            mView.changeRestState(rest);
        });
    }
}
