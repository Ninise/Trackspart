package com.ninise.trackspart.mvp.presenter.main.fragment;

import com.ninise.trackspart.mvp.presenter.IStateView;

public interface ITimerView extends IStateView {

    void onStopTimer();
    void backToMain();

}
