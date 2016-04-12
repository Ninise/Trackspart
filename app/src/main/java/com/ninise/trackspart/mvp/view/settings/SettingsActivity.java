package com.ninise.trackspart.mvp.view.settings;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;
import com.jakewharton.rxbinding.view.RxView;
import com.ninise.trackspart.R;

import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity {

    @Bind(R.id.settingsToolbar) Toolbar mToolbar;
    @Bind(R.id.settingsPrepareSpinner) AppCompatSpinner mPrepareSpinner;
    @Bind(R.id.settingsSaveDataCheckBox) AppCompatCheckBox mSaveCheckBox;
    @Bind(R.id.settingsSaveBtn) Button mSaveButton;
    @BindDrawable(R.drawable.ic_action_navigation_arrow_back) Drawable mBackDrawable;
    @BindString(R.string.menu_settings) String mSettingsString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        ButterKnife.bind(this);

        mToolbar.setTitle(mSettingsString);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(mBackDrawable);

        RxToolbar.navigationClicks(mToolbar).subscribe(v -> onBackPressed());

        ArrayAdapter<?> adapterPrepareList =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.prepare_list,
                        android.R.layout.simple_spinner_item);

        adapterPrepareList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mPrepareSpinner.setAdapter(adapterPrepareList);

        RxView.clicks(mSaveButton).subscribe(v -> {

            onBackPressed();
        });
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
