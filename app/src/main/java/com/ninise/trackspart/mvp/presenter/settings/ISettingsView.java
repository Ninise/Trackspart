package com.ninise.trackspart.mvp.presenter.settings;

public interface ISettingsView {

    void setSaveLastState(boolean state);
    void setPrepareTime(int state);
    void setSavedSettings(int spinnerPos, boolean checkState);
    void onSaved();

}
