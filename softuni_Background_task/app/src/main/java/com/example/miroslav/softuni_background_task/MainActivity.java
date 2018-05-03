package com.example.miroslav.softuni_background_task;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView txtProgres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtProgres = findViewById(R.id.txt_progress);

        registerReceiver(
                new CustomReceiver(),
                new IntentFilter(ImageDownloadIntentService.MY_ACTION));

        //register broadcast receiver


        //startService(new Intent(this, ImageDownloadIntentService.class));
/*
        IntentFilter filter = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(new NetworkReceiver(), filter);*/

      /*  for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

*/

        //only for 1 task of Async task
        /*new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {

                //in background

                return null;
            }
        }.execute();*/
    }


    protected void onButtonPressed(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);
        service.getCurrentWeather("Sofia").enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if(response.isSuccessful()){
                    CurrentWeather currentWeather = response.body();
                    Log.e("TAG", currentWeather.toString());
                }
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {

            }
        });

       /* super.onResume();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
      /*  Log.e("TAG", "shoud start service");
        Intent intent = new Intent(this, ImageDownloadIntentService.class);
        intent.putExtra("key", 12);
        startService(intent);*/

      startService(new Intent(this, TestService.class));


      /* SleeperTask task = new SleeperTask();
        task.setTxtProgress(txtProgres);
       task.execute(10,20,30);*/

    }


}
