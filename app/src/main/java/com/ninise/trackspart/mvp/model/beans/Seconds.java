package com.ninise.trackspart.mvp.model.beans;

public class Seconds {

    private static Seconds mInstance = null;

    private int count;

    private Seconds() {
        this.count = 0;
    }

    public static Seconds getInstance() {
        if (mInstance == null) {
            mInstance = new Seconds();
        }
        return mInstance;
    }

    public int getCount() {
        return count;
    }

    public void incSecs() {
        count += 1;
    }

    public void decSecs() {
        if (count <= 0) {
            count = 0;
        } else {
            count -= 1;
        }
    }

    public void setCount(int c) {
        if (c <= 0) {
            count = 0;
        } else {
            count = c;
        }
    }
}
