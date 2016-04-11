package com.ninise.trackspart.mvp.presenter.main.fragment;

import com.ninise.trackspart.mvp.model.timer.IntervalTimer;

public class TimerPresenter implements ITimerPresenter {

    private ITimerView mView;

    public TimerPresenter(ITimerView view) {
        mView = view;
    }

    @Override
    public void startTimer(int sets, int seconds, int rest) {
        mView.changeSetsState(sets);
        mView.changeRestState(rest);

        int[] set = {sets};

        IntervalTimer.startTimer(seconds, rest)
               .doOnCompleted(() -> mView.changeSetsState(--set[0]))
               .repeat(sets)
               .subscribe(tick -> {
                    if (rest < tick) {
                        mView.changeSecsState(tick - rest);
                        mView.onSecs();
                    } else {
                        mView.changeSecsState(0);
                        mView.changeRestState(--tick);
                        mView.onRest();
                    }
               }, e -> {}, () -> {
                   mView.onStopTimer();
                   mView.backToMain();
               });
    }
}
