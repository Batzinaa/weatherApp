package com.example.myapplication.data;

import com.example.myapplication.Util.Utils;
import com.example.myapplication.model.Location;
import com.example.myapplication.model.Weather;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONWeatherParser {

    public static Weather getWeather(String data){
        Weather weather = new Weather();

        //create JSONObject from data

        try {
            JSONObject jsonObject = new JSONObject(data);

            Location location = new Location();

            JSONObject locationObj = Utils.getObject("coord",jsonObject);
            location.setLat(Utils.getFloat("lat",locationObj));
            location.setLon(Utils.getFloat("lon",locationObj));
            location.setName(Utils.getString("name",jsonObject));

            weather.location = location;

            return weather;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
