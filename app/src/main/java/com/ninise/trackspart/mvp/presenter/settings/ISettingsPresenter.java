package com.ninise.trackspart.mvp.presenter.settings;

public interface ISettingsPresenter {

    void save(Object spinnerPos, boolean checkState);
    void onBack();
}
