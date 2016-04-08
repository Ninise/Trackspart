package com.ninise.trackspart.mvp.presenter;

import android.util.Log;

public class MainPresenter implements IMainPresenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    private IMainView mView;

    public MainPresenter(IMainView view) {
        mView = view;
    }

    @Override
    public void setSetsState(int count) {
        Log.d(TAG, "setSetsState: " + count);

        mView.changeSetsState(count);
    }

    @Override
    public void setSecsState(int count) {
        Log.d(TAG, "setSecsState: " + count);

        mView.changeSecsState(count);
    }

    @Override
    public void setRestState(int count) {
        Log.d(TAG, "setRestState: " + count);

        mView.changeRestState(count);
    }
}
