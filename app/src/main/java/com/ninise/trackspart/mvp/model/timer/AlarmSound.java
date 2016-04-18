package com.ninise.trackspart.mvp.model.timer;

import android.content.Context;
import android.media.MediaPlayer;

import com.ninise.trackspart.R;

public class AlarmSound {

    public static void onSet(Context context) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.status_sound);
        mediaPlayer.start();
    }

}
