package com.ninise.trackspart.mvp.presenter.settings;

import android.content.Context;

import com.ninise.trackspart.mvp.model.preferences.SettingsPreferences;

public class SettingsPresenter implements ISettingsPresenter {

    private ISettingsView mView;

    public SettingsPresenter(ISettingsView view) {
        mView = view;
    }

    @Override
    public void save(Context context, int spinnerPos, boolean checkStateSData, boolean checkStateSound) {
        SettingsPreferences.getInstance(context).setSaveLastCheckBox(checkStateSData);
        SettingsPreferences.getInstance(context).setSpinnerPosition(spinnerPos);
        SettingsPreferences.getInstance(context).setSoundState(checkStateSound);

        mView.onSaved();
    }

    @Override
    public void getDefaultSaveLastState(Context context) {
        mView.setSaveLastState(SettingsPreferences.getInstance(context).getSaveLastCheckBox());
    }

    @Override
    public void getDefaultSpinnerPosition(Context context) {
        mView.setPrepareTime(SettingsPreferences.getInstance(context).getSpinnerPosition());
    }

    @Override
    public void getDefaultSoundState(Context context) {
        mView.setSoundState(SettingsPreferences.getInstance(context).getSoundState());
    }

    @Override
    public void onBack() {
        mView.onSaved();
    }
}
