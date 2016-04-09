package com.ninise.trackspart.mvp.presenter.main.fragment;

import com.ninise.trackspart.mvp.model.timer.IntervalTimer;
import com.ninise.trackspart.mvp.presenter.IStateView;

import rx.android.schedulers.AndroidSchedulers;

public class TimerPresenter implements ITimerPresenter {

    private IStateView mView;

    public TimerPresenter(IStateView view) {
        mView = view;
    }

    @Override
    public void startTimer(int sets, int seconds, int rest) {
        mView.changeSetsState(sets);
        mView.changeRestState(rest);

        IntervalTimer.startTimer(seconds)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(num -> mView.changeSecsState(num.intValue() + 1), e -> {},
                        () ->
                            IntervalTimer.startTimer(rest)
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(num -> mView.changeRestState(num.intValue() + 1))

                );
    }
}
