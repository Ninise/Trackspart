package com.ninise.trackspart.mvp.view.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ninise.trackspart.R;

import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.homeToolbar) Toolbar mHomeToolbar;
    @BindDrawable(R.mipmap.ic_launcher) Drawable mLogoToolbarDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);

        setSupportActionBar(mHomeToolbar);
        mHomeToolbar.setNavigationIcon(mLogoToolbarDrawable);


    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
