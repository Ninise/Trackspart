package com.ninise.trackspart.mvp.view.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.ninise.trackspart.R;
import com.ninise.trackspart.mvp.presenter.IMainView;
import com.ninise.trackspart.mvp.presenter.MainPresenter;

import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainView {

    @Bind(R.id.homeToolbar) Toolbar mHomeToolbar;
    @Bind(R.id.homeStartButton) Button mGoButton;
    @Bind(R.id.homeTabLay) TableLayout mTableLayout;
    @BindDrawable(R.mipmap.ic_launcher) Drawable mLogoToolbarDrawable;

    private MainPresenter mPresenter;
    private TableRow setsRow = (TableRow) mTableLayout.getChildAt(0);
    private TableRow secsRow = (TableRow) mTableLayout.getChildAt(1);
    private TableRow restRow = (TableRow) mTableLayout.getChildAt(2);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);

        setSupportActionBar(mHomeToolbar);
        mHomeToolbar.setNavigationIcon(mLogoToolbarDrawable);
        
        RxView.clicks(setsRow.getChildAt(2)).subscribe(

        );

        RxView.clicks(setsRow.getChildAt(0)).subscribe(

        );

        RxView.clicks(secsRow.getChildAt(2)).subscribe();
        RxView.clicks(secsRow.getChildAt(0)).subscribe();

        RxView.clicks(restRow.getChildAt(2)).subscribe();
        RxView.clicks(restRow.getChildAt(0)).subscribe();


        RxView.clicks(mGoButton).subscribe(

        );

        mPresenter = new MainPresenter(this);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    @Override
    public void changeSetsState(int state) {
        TextView sets = (TextView) setsRow.getChildAt(1);
    }

    @Override
    public void changeSecsState(int state) {
        TextView secs = (TextView) secsRow.getChildAt(1);

    }

    @Override
    public void changeRestState(int state) {
        TextView rest = (TextView) restRow.getChildAt(1);

    }
}
