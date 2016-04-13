package com.ninise.trackspart.mvp.model.beans;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class RestTest {

    @Test
    public void testGetInstance() throws Exception {
        Assertions.assertThat(Rest.getInstance()).isNotNull();
    }

    @Test
    public void testGetCount() throws Exception {
        Assertions.assertThat(Rest.getInstance().getCount()).isNotNull();
        Assertions.assertThat(Rest.getInstance().getCount()).isEqualTo(0);
    }

    @Test
    public void testIncRest() throws Exception {
        Rest.getInstance().incRest();
        Assertions.assertThat(Rest.getInstance().getCount()).isEqualTo(1);
    }

    @Test
    public void testDecRest() throws Exception {
        Rest.getInstance().decRest();
        Assertions.assertThat(Rest.getInstance().getCount()).isEqualTo(0);
    }

    @Test
    public void testSetCount() throws Exception {
        Rest.getInstance().setCount(-2);
        Assertions.assertThat(Rest.getInstance().getCount()).isZero();
    }
}