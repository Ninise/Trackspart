package com.ninise.trackspart.mvp.view.main

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.bindView
import com.ninise.trackspart.R

class MainActivity : AppCompatActivity() {

    val mToolBar: Toolbar by bindView(R.id.homeToolbar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setSupportActionBar(mToolBar)
        mToolBar.setNavigationIcon(R.mipmap.ic_launcher)
    }
}
