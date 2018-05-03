package com.example.miroslav.softuni_background_task;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class TestService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG", "On start command");
        return START_STICKY;
                //super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TAG", "onBind");
        return null;
    }
}
