package com.example.miroslav.a09_android_design_patterns.services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient (){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder().baseUrl("https://world.openfoodfacts.org/api/v0/product/737628064502.json")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                            .build();
                return retrofit;

    }
}
