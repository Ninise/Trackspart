package com.ninise.trackspart.mvp.model.timer;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

public class SecondsTimer {

    public static Observable<Long> startSecondsTimer(int count) {
        return Observable.interval(1, TimeUnit.SECONDS, Schedulers.io())
                .filter(i -> i <= count);
    }
}
