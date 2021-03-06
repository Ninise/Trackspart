package com.ninise.trackspart.mvp.view.main;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;
import com.ninise.trackspart.R;
import com.ninise.trackspart.mvp.presenter.main.activity.IMainActivityView;
import com.ninise.trackspart.mvp.presenter.main.activity.MainPresenter;

import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainActivityView {

    @Bind(R.id.homeToolbar) Toolbar mHomeToolbar;
    @BindString(R.string.app_name) String mAppNameString;
    @BindDrawable(R.mipmap.ic_launcher) Drawable mLogoToolbarDrawable;

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);

        MainPresenter presenter = new MainPresenter(this);

        setSupportActionBar(mHomeToolbar);
        mHomeToolbar.setTitle(mAppNameString);
        mHomeToolbar.setNavigationIcon(mLogoToolbarDrawable);

        RxToolbar.itemClicks(mHomeToolbar).subscribe(presenter::onMenuItemClick);

        showMainFragment();
    }

    private void showMainFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainContainer, new MainFragment());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getString(R.string.back_pressed), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    public void switchToFragment(Class c) {
        startActivity(new Intent(this, c));
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    public void exit() {
        finish();
    }
}
