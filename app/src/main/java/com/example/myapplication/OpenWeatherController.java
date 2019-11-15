package com.example.myapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.data.JSONWeatherParser;
import com.example.myapplication.data.WeatherHttpClient;
import com.example.myapplication.openWeather_model.OpenWeatherMap;

public class OpenWeatherController {
    private final String API_KEY = "ee6892eaa4ce0be1a8eac7817898d322";

    private OpenWeatherMap weatherMap;
    private TextView result;
    private double lat = 41.090923;
    private double lon = 23.54132;
    
    public OpenWeatherController(Activity activity){
        weatherMap = new OpenWeatherMap();
        String url = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&APPID="+API_KEY+"&units=metric";
        new WeatherTask().execute(url);
        result = activity.findViewById(R.id.Result);
    }


    private class WeatherTask extends AsyncTask<String,Void, OpenWeatherMap> {
        @Override
        protected OpenWeatherMap doInBackground(String... strings) {
            String data = ((new WeatherHttpClient()).getWeatherData(strings[0]));
            weatherMap = JSONWeatherParser.getWeather(data);
//            Log.v("Data:", weatherMap.wind.getDeg());
//            Log.v("Data:", weatherMap.wind.getSpeed());
            return weatherMap;
        }

        @Override
        protected void onPostExecute(OpenWeatherMap weather) {
            super.onPostExecute(weather);
            result.setText("Temp: "+weatherMap.main.getTemp()+"\n   "+weatherMap.simple.getCityName()+" "+weatherMap.sys.getCountry());
        }

    }
}
