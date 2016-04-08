package com.ninise.trackspart.mvp.presenter.main.activity;

public class MainPresenter implements IMainPresenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    private IMainView mView;

    public MainPresenter(IMainView view) {
        mView = view;
    }

    @Override
    public void setSetsState(int count) {
        mView.changeSetsState(count);
    }

    @Override
    public void setSecsState(int count) {
        mView.changeSecsState(count);
    }

    @Override
    public void setRestState(int count) {
        mView.changeRestState(count);
    }

    @Override
    public void startTimer(int sets, int seconds, int rest) {
       mView.displayWork();
    }
}
