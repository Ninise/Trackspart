package com.ninise.trackspart.mvp.model.timer;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

public class IntervalTimer {

    public static Observable<Long> startTimer(int count) {
        return Observable.interval(1, TimeUnit.SECONDS, Schedulers.io()).take(count);
    }
}
