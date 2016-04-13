package com.ninise.trackspart.mvp.presenter.main.activity;

import android.content.Context;

public interface IMainPresenter {

    void setSetsState(int count);
    void setSecsState(int count);
    void setRestState(int count);
    void setOldOptions(Context context);
    void saveOptions(Context context, int sets, int secs, int rest);
    void startTimer(int sets, int seconds, int rest);
}
