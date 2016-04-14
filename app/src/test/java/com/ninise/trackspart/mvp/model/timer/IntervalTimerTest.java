package com.ninise.trackspart.mvp.model.timer;

import com.ninise.trackspart.BuildConfig;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class IntervalTimerTest {

    ShadowActivity mActivity = new ShadowActivity();

    @Test
    public void testStartTimer() throws Exception {
        List<Integer> arr = new ArrayList<>();
        Assertions.assertThat(IntervalTimer.startTimer(mActivity.getApplicationContext(), 1, 4)).isNotNull();
    }
}