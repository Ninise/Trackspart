package com.ninise.trackspart.mvp.presenter.settings;

import android.content.Context;

public interface ISettingsPresenter {

    void save(Context context, int spinnerPos, boolean checkStateSData, boolean checkStateSound);
    void getDefaultSaveLastState(Context context);
    void getDefaultSpinnerPosition(Context context);
    void getDefaultSoundState(Context context);
    void onBack();
}
