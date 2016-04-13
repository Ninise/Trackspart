package com.ninise.trackspart.mvp.presenter.main.fragment;

import com.ninise.trackspart.mvp.presenter.main.IStateView;

public interface ITimerView extends IStateView {

    void onStopTimer();
    void backToMain();

    void changePrepareState(int state);
}
