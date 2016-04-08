package com.ninise.trackspart.mvp.presenter.main.activity;

public interface IMainPresenter {

    void setSetsState(int count);
    void setSecsState(int count);
    void setRestState(int count);
    void startTimer(int sets, int seconds, int rest);
}
