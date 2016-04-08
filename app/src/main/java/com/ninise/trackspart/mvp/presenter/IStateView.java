package com.ninise.trackspart.mvp.presenter;

public interface IStateView {

    void changeSetsState(int state);
    void changeSecsState(int state);
    void changeRestState(int state);

}
