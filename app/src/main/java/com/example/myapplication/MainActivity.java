package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView cityName;
    private TextView temp;
    private TextView humidity;
    private TextView pressure;
    private TextView wind;

    private OpenWeatherController openWeatherController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openWeatherController = new OpenWeatherController(this);
    }

}
