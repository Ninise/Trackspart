package com.ninise.trackspart.mvp.model.beans;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class SetsTest {

    @Test
    public void testGetInstance() throws Exception {
        Assertions.assertThat(Sets.getInstance()).isNotNull();
    }

    @Test
    public void testGetCount() throws Exception {
        Assertions.assertThat(Sets.getInstance().getCount()).isNotNull();
        Assertions.assertThat(Sets.getInstance().getCount()).isEqualTo(0);
    }

    @Test
    public void testIncSets() throws Exception {
        Sets.getInstance().incSets();
        Assertions.assertThat(Sets.getInstance().getCount()).isEqualTo(1);
    }

    @Test
    public void testDecSets() throws Exception {
        Sets.getInstance().decSets();
        Assertions.assertThat(Sets.getInstance().getCount()).isEqualTo(0);
    }

    @Test
    public void testSetCount() throws Exception {
        Sets.getInstance().setCount(-2);
        Assertions.assertThat(Sets.getInstance().getCount()).isZero();
    }
}