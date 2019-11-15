package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.example.myapplication.data.JSONWeatherParser;
import com.example.myapplication.data.WeatherHttpClient;
import com.example.myapplication.openWeather_model.OpenWeatherMap;

public class MainActivity extends AppCompatActivity {
    private TextView cityName;
    private TextView temp;
    private TextView humidity;
    private TextView pressure;
    private TextView wind;


    OpenWeatherMap weatherMap = new OpenWeatherMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpenWeatherController myController = new OpenWeatherController(this);

    }

}
