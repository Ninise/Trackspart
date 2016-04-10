package com.ninise.trackspart.mvp.presenter.main.fragment;

import com.ninise.trackspart.mvp.model.timer.IntervalTimer;
import com.ninise.trackspart.mvp.presenter.IStateView;

public class TimerPresenter implements ITimerPresenter{

    private IStateView mView;

    public TimerPresenter(IStateView view) {
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
                    } else {
                        mView.changeSecsState(0);
                        mView.changeRestState(--tick);
                    }
               });
    }
}
