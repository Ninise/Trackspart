package com.ninise.trackspart.mvp.presenter.settings;

import android.content.Context;
import android.util.Log;

import com.ninise.trackspart.mvp.model.preferences.SettingsPreferences;

public class SettingsPresenter implements ISettingsPresenter {

    private ISettingsView mView;

    public SettingsPresenter(ISettingsView view) {
        mView = view;
    }

    @Override
    public void save(Context context, int spinnerPos, boolean checkState) {
        SettingsPreferences.getInstance(context).setSaveLastCheckBox(checkState);
        SettingsPreferences.getInstance(context).setSpinnerPosition(spinnerPos);
        Log.d("das", "save: " + spinnerPos);

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
    public void onBack() {
        mView.onSaved();
    }
}
