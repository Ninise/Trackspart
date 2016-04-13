package com.ninise.trackspart.mvp.model.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.ninise.trackspart.utils.Constants;

public class SettingsPreferences {

    private static SettingsPreferences mInstance = null;

    private SharedPreferences mPreferences;

    private SettingsPreferences(Context context) {
        mPreferences = context.getSharedPreferences(
                Constants.SETTINGS_PREFERENCES,
                Context.MODE_PRIVATE);
    }

    public static SettingsPreferences getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SettingsPreferences(context);
        }

        return mInstance;
    }

    public boolean setSpinnerPosition(int num) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(Constants.SETTINGS_SPINNER, num);
        return editor.commit();
    }

    public int getSpinnerPosition() {
        return mPreferences.contains(Constants.SETTINGS_SPINNER) ?
                mPreferences.getInt(Constants.SETTINGS_SPINNER, 5) : 5;
    }

    public boolean setSaveLastCheckBox(boolean state) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(Constants.SETTINGS_SAVE_LAST, state);
        return editor.commit();
    }

    public boolean getSaveLastCheckBox() {
        return mPreferences.contains(Constants.SETTINGS_SAVE_LAST) &&
                mPreferences.getBoolean(Constants.SETTINGS_SAVE_LAST, false);
    }

    public boolean setSetsCount(int count) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(Constants.SETTINGS_SETS, count);
        return editor.commit();
    }

    public int getSetsCount() {
       return mPreferences.contains(Constants.SETTINGS_SETS) ?
                mPreferences.getInt(Constants.SETTINGS_SETS, 0) : 0;
    }

    public boolean setSecondsCount(int count) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(Constants.SETTINGS_SECONDS, count);
        return editor.commit();
    }

    public int getSecondsCount() {
        return mPreferences.contains(Constants.SETTINGS_SECONDS) ?
                mPreferences.getInt(Constants.SETTINGS_SECONDS, 0) : 0;
    }

    public boolean setRestCount(int count) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(Constants.SETTINGS_REST, count);
        return editor.commit();
    }

    public int getRestCount() {
        return mPreferences.contains(Constants.SETTINGS_REST) ?
                mPreferences.getInt(Constants.SETTINGS_REST, 0) : 0;
    }
}
