package com.ninise.trackspart.mvp.model.beans;


public class Rest {

    private static Rest mInstance = null;

    int count;

    private Rest() {
        this.count = 0;
    }

    public static Rest getInstance() {
        if (mInstance == null) {
            mInstance = new Rest();
        }
        return mInstance;
    }

    public int getCount() {
        return count;
    }

    public void incRest() {
        count += 1;
    }

    public void decRest() {
        if (count <= 0) {
            count = 0;
        } else {
            count -= 1;
        }
    }
}
