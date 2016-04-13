package com.ninise.trackspart.mvp.model.beans;


public class Sets {

    private static Sets mInstance = null;

    private int count;

    private Sets() {
        this.count = 0;
    }

    public static Sets getInstance() {
        if (mInstance == null) {
            mInstance = new Sets();
        }
        return mInstance;
    }

    public int getCount() {
        return count;
    }

    public void incSets() {
           count += 1;
    }

    public void decSets() {
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
