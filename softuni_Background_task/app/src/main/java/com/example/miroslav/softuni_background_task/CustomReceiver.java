package com.example.miroslav.softuni_background_task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,
                "Conectivety changed " + intent.getIntExtra("newkey", -1),
                Toast.LENGTH_LONG
        ).show();
    }
}
