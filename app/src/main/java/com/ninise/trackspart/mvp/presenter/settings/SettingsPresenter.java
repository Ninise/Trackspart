package com.ninise.trackspart.mvp.presenter.settings;

public class SettingsPresenter implements ISettingsPresenter {

    private ISettingsView mView;

    public SettingsPresenter(ISettingsView view) {
        mView = view;
    }

    @Override
    public void save(Object spinnerPos, boolean checkState) {
        
        mView.onSaved();
    }

    @Override
    public void onBack() {
        mView.onSaved();
    }
}
