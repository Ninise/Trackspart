package com.ninise.trackspart.mvp.presenter.main.fragment;

import android.content.Context;
import android.util.Log;

import com.ninise.trackspart.mvp.model.preferences.SettingsPreferences;
import com.ninise.trackspart.mvp.model.timer.AlarmSound;
import com.ninise.trackspart.mvp.model.timer.IntervalTimer;

public class TimerPresenter implements ITimerPresenter {

    private ITimerView mView;

    public TimerPresenter(ITimerView view) {
        mView = view;
    }

    @Override
    public void startTimer(Context context, int sets, int seconds, int rest) {
        mView.changeSetsState(sets);
        mView.changeRestState(rest);

        int[] set = {sets};

        IntervalTimer.startTimer(context, seconds, rest)
               .doOnCompleted(() -> {
                   mView.changeSetsState(--set[0]);
                   if (SettingsPreferences.getInstance(context).getSoundState()) {
                       AlarmSound.onSet(context);
                   }
               })
               .repeat(sets)
               .subscribe(tick -> {
                   if (rest + seconds < tick) {
                       mView.changePrepareState(tick - seconds - rest);
                   } else {
                       if (rest < tick) {
                           mView.changeSecsState(tick - rest);
                       } else {
                           mView.changeRestState(--tick);
                       }
                   }
               }, e -> {}, () -> {
                   mView.onStopTimer();
                   mView.backToMain();
               });
    }
}
