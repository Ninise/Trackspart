package com.ninise.trackspart.mvp.presenter.settings;

import android.content.Context;

public interface ISettingsPresenter {

    void save(Context context, int spinnerPos, boolean checkState);
    void getDefaultSaveLastState(Context context);
    void getDefaultSpinnerPosition(Context context);
    void onBack();
}
