package com.ninise.trackspart.mvp.model.beans;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class SecondsTest {

    @Test
    public void testGetInstance() throws Exception {
        Assertions.assertThat(Seconds.getInstance()).isNotNull();
    }

    @Test
    public void testGetCount() throws Exception {
        Assertions.assertThat(Seconds.getInstance().getCount()).isNotNull();
        Assertions.assertThat(Seconds.getInstance().getCount()).isEqualTo(0);
    }

    @Test
    public void testIncSecs() throws Exception {
        Seconds.getInstance().incSecs();
        Assertions.assertThat(Seconds.getInstance().getCount()).isEqualTo(1);
    }

    @Test
    public void testDecSecs() throws Exception {
        Seconds.getInstance().decSecs();
        Assertions.assertThat(Seconds.getInstance().getCount()).isEqualTo(0);
    }

    @Test
    public void testSetCount() throws Exception {
        Seconds.getInstance().setCount(-2);
        Assertions.assertThat(Seconds.getInstance().getCount()).isZero();
    }
}