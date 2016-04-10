package com.ninise.trackspart.mvp.model.timer;

import android.os.CountDownTimer;

import rx.Observable;

public class IntervalTimer {

    public static Observable<Integer> startTimer(int seconds, int rest) {
        return Observable.create((Observable.OnSubscribe<Integer>)  subscriber ->
           new CountDownTimer((seconds + rest) * 1000, 1000) {

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
