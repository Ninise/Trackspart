package com.ninise.trackspart.mvp.view.about;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;
import com.jakewharton.rxbinding.view.RxView;
import com.ninise.trackspart.R;

import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity {

    @Bind(R.id.aboutToolbar) Toolbar mToolbar;
    @Bind(R.id.aboutOkBtn) Button mOkButton;
    @BindDrawable(R.drawable.ic_action_navigation_arrow_back) Drawable mBackDrawable;
    @BindString(R.string.menu_about) String mAboutString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(mBackDrawable);
        mToolbar.setTitle(mAboutString);
        RxToolbar.navigationClicks(mToolbar).subscribe(aVoid -> onBackPressed());

        RxView.clicks(mOkButton).subscribe(aVoid -> onBackPressed());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
