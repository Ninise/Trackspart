package com.ninise.trackspart.mvp.model.timer;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

public class IntervalTimer {

    public static Observable<Long> startSecondsTimer(int count) {
//        return Observable.just(Observable.interval(1, TimeUnit.SECONDS, Schedulers.io())
//                .filter(i -> i <= count)
//        );

        return Observable.interval(1, TimeUnit.SECONDS, Schedulers.io())
                .take(count);
    }
}
