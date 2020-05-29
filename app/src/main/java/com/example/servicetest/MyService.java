package com.example.servicetest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "service onCreate", Toast.LENGTH_SHORT).show();
        mp = MediaPlayer.create(this, R.raw.chacha);
        mp.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service onStartCommand", Toast.LENGTH_SHORT).show();
        mp.start();
        Toast.makeText(getApplicationContext(), ""+mp.getDuration(), Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp != null) {
            mp.release();
            mp = null;
        }
        Toast.makeText(this, "service onDestroy", Toast.LENGTH_SHORT).show();
    }
}
