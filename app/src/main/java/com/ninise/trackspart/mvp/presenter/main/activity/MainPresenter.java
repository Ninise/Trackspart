package com.ninise.trackspart.mvp.presenter.main.activity;

import android.content.Context;
import android.view.MenuItem;

import com.ninise.trackspart.R;
import com.ninise.trackspart.mvp.model.beans.Rest;
import com.ninise.trackspart.mvp.model.beans.Seconds;
import com.ninise.trackspart.mvp.model.beans.Sets;
import com.ninise.trackspart.mvp.model.preferences.SettingsPreferences;
import com.ninise.trackspart.mvp.view.about.AboutActivity;
import com.ninise.trackspart.mvp.view.settings.SettingsActivity;

public class MainPresenter implements IMainPresenter {

    private IMainView mView;
    private IMainActivityView mIMainActivityView;

    public MainPresenter(IMainView view) {
        mView = view;
    }

    public MainPresenter(IMainActivityView view) {
        this.mIMainActivityView = view;
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
    public void setOldOptions(Context context) {
        if (SettingsPreferences.getInstance(context).getSaveLastCheckBox()) {
            Sets.getInstance().setCount(SettingsPreferences.getInstance(context).getSetsCount());
            Seconds.getInstance().setCount(SettingsPreferences.getInstance(context).getSecondsCount());
            Rest.getInstance().setCount(SettingsPreferences.getInstance(context).getRestCount());
        }
    }

    @Override
    public void saveOptions(Context context, int sets, int secs, int rest) {
        if (SettingsPreferences.getInstance(context).getSaveLastCheckBox()) {
            SettingsPreferences.getInstance(context).setSetsCount(sets);
            SettingsPreferences.getInstance(context).setSecondsCount(secs);
            SettingsPreferences.getInstance(context).setRestCount(rest);
        }
    }

    @Override
    public void startTimer(int sets, int seconds, int rest) {
       mView.displayWork();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menuSettings:
                mIMainActivityView.switchToFragment(SettingsActivity.class);
                return true;
            case R.id.menuAbout:
                mIMainActivityView.switchToFragment(AboutActivity.class);
                return true;
            case R.id.menuExit:
                mIMainActivityView.exit();
                return true;
        }

        return false;
    }
}
