package com.example.miroslav.softuni_background_task;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {

    public static final String URL = "http://api.openweathermap.org/data/2.5/";

   // @GET("weather?q={city}&APPID=9d2885afccf55c3f071534233d63f297")
   @GET("/data/2.5/weather?id=524901&APPID=9d2885afccf55c3f071534233d63f297")
    Call<CurrentWeather> getCurrentWeather(@Query("city") String city);
}
