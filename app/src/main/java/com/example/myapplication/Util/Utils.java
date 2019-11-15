package com.example.myapplication.Util;

import org.json.JSONException;
import org.json.JSONObject;

public class Utils {

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=Serres%2Cgr&APPID=ee6892eaa4ce0be1a8eac7817898d322&units=metric&fbclid=IwAR0tkGU676Nc7Uxphup0pMihHhm8POk9lwYj6kB20W4cFGsoAEcX8k0MTYA";
    public static final String ICON_URL = "";

    public static JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException{
        JSONObject jObj = jsonObject.getJSONObject(tagName);
        return  jObj;
    }

    public static String getString(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getString(tagName);
    }

    public static  float getFloat(String tagName, JSONObject jsonObject) throws JSONException{
        return (float) jsonObject.getDouble(tagName);
    }

    public static double getDouble(String tagName, JSONObject jsonObject) throws JSONException{
        return (float) jsonObject.getDouble(tagName);
    }
    public static int getInt(String tagName, JSONObject jsonObject) throws JSONException{
        return jsonObject.getInt(tagName);
    }
}
