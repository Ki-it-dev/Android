package com.example.lehuunhatkhoa_b9_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer mymusic;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mymusic = MediaPlayer.create(MyService.this,R.raw.trentinhbanduoitinhyeu);
        mymusic.setLooping(true);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(mymusic.isPlaying()){
            mymusic.pause();
        }else{
            mymusic.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mymusic.stop();
    }
}