package com.ninise.trackspart.mvp.model.timer;


import java.util.concurrent.TimeUnit;

import rx.Observable;

public class SecondsTimer {

    public Observable<Long> startSecondsTimer() {
        return Observable.interval(1, TimeUnit.SECONDS)
                .filter(i -> i < 10);
    }
}
