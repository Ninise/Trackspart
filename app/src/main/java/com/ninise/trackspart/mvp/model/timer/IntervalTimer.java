package com.ninise.trackspart.mvp.model.timer;

import android.content.Context;
import android.os.CountDownTimer;

import com.ninise.trackspart.mvp.model.preferences.SettingsPreferences;

import rx.Observable;

public class IntervalTimer {

    public static Observable<Integer> startTimer(Context context, int seconds, int rest) {
        int prepare = (SettingsPreferences.getInstance(context).getSpinnerPosition() + 1) * 5;

        return Observable.create((Observable.OnSubscribe<Integer>)  subscriber ->
           new CountDownTimer((seconds + rest + prepare) * 1000, 1000) {

                public void onTick(long millisUntilFinished) {
                    subscriber.onNext((int) (millisUntilFinished / 1000));
                }

                public void onFinish() {
                    subscriber.onCompleted();
                }
            }.start()

       );
    }
}
