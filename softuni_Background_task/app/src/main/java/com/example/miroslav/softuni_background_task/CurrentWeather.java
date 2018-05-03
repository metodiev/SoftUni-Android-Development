package com.example.miroslav.softuni_background_task;

import java.util.Arrays;

public class CurrentWeather {

    private Weather [] weather;
    private Main main;

    class Main{
       public double tempreture;
       public double pressure;

    }

    class Weather{
        public String desctiption;
    }


    public String getDescription(){
        return weather[0].desctiption;
    }

    public double getTemp(){
        return main.tempreture;
    }

    public double getPressure(){
        return main.pressure;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" + "\n"+
                getDescription() + "\n" +
                getPressure() + "\n" +
                getTemp() + "\n";
    }
}
