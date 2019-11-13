package com.example.myapplication.model;

public class Weather {

    public Location location;
    public String iconData;
    public CurrentWeather currentWeather = new CurrentWeather();
    public Temperature temperature = new Temperature();
    public Wind wind = new Wind();
    public Clouds clouds = new Clouds();

}
