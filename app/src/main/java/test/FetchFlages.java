package test;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class FetchFlages {

    Context context;
    String placeurl="https://maps.googleapis.com/maps/api/place/textsearch/jsonquery=";
    String myapi = "&key=AIzaSyBuI5wpF733jBS8s7HzjybE1rYAp1hA5tA";
    RequestQueue requestQueue;
    CustomListener listener = null; //Your listener instance


    public FetchFlages(Context context, CustomListener listener) {
        this.context = context;
        this.listener = listener;
        requestQueue = Volley.newRequestQueue(context);
    }
    public void getPhotoReference(){

        String url = placeurl +"China"+myapi;
        StringRequest objectRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onVolleyResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volly Error",error.toString());
            }
        });
        requestQueue.add(objectRequest);
    }
}
