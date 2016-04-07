package com.ninise.trackspart.mvp.presenter;

public class MainPresenter implements IMainPresenter {

    private IMainView mView;

    public MainPresenter(IMainView view) {
        mView = view;
    }

    @Override
    public void setSetsState(int count) {

    }

    @Override
    public void setSecsState(int count) {

    }

    @Override
    public void setRestState(int count) {

    }
}
