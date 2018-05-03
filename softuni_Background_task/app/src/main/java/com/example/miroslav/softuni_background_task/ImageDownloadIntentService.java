package com.example.miroslav.softuni_background_task;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class ImageDownloadIntentService extends IntentService {



    public static  final String MY_ACTION = "com.example.miroslav.softuni_background_task.CUSTOM_ACTION";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ImageDownloadIntentService(String name) {
        super(name);
        Log.e("TAG", "shoud start service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("TAG", "shoud start service");
        int data = intent.getIntExtra("key", 0);

        Log.e("TAG", "Intent servive is started");
        //in a new thread
        //broadcast with the result
        Intent localIntent = new Intent(MY_ACTION)
// Puts the status into the Intent
                        .putExtra("newkey", 13);
// Broadcasts the Intent to receivers in this app.
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }
}
