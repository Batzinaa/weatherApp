package com.example.myapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.data.JSONWeatherParser;
import com.example.myapplication.data.WeatherHttpClient;
import com.example.myapplication.openWeather_model.OpenWeatherMap;

public class OpenWeatherController {

    OpenWeatherMap weatherMap = new OpenWeatherMap();
    TextView result;

    public OpenWeatherController(Activity activity){
       renderWeatherData("serres");
        result = activity.findViewById(R.id.Result);
    }

    public void renderWeatherData(String city){
        WeatherTask weatherTask = new WeatherTask();
        weatherTask.execute(new String[]{city}+"&units=metric");
    }


    private class WeatherTask extends AsyncTask<String,Void, OpenWeatherMap> {



        @Override
        protected OpenWeatherMap doInBackground(String... strings) {
            String data = ((new WeatherHttpClient()).getWeatherData(strings[0]));
            weatherMap= JSONWeatherParser.getWeather(data);
            Log.v("Data:", weatherMap.wind.getDeg());
            Log.v("Data:", weatherMap.wind.getSpeed());
            return weatherMap;
        }

        @Override
        protected void onPostExecute(OpenWeatherMap weather) {
            super.onPostExecute(weather);
            result.setText(weatherMap.wind.getDeg()+" "+weatherMap.coord.getLat()+ " "+weatherMap.main.getTemp()+" "+weatherMap.sys.getCountry());
        }

    }
}
