package com.amirshiati.androidwoocommercesdk.helper;

import android.content.Context;
import android.os.Build;
import android.util.Base64;

import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonArrayFinished;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import java.util.HashMap;
import java.util.Map;

public class Volley {

    private Context context;
    private String ckKey;
    private String csKey;

    private int timeOut = 10000;

    public Volley(Context context, String ckKey, String csKey, int timeOut) {
        this.context = context;
        this.ckKey = ckKey;
        this.csKey = csKey;
        this.timeOut = timeOut;
    }

    public void basicAuthJsonArrayReq(int method, String url, JSONArray jsonArray, final OnGetJsonArrayFinished onGetJsonArrayFinished) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(method,
                url,
                jsonArray,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        onGetJsonArrayFinished.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onGetJsonArrayFinished.onFail(error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                    params.put("Authorization",
                            String.format("Basic %s", Base64.encodeToString(String.format("%s:%s", ckKey, csKey).getBytes(), Base64.NO_WRAP)));
                }
                params.put("username", ckKey);
                params.put("password", csKey);
                return params;
            }

            @Override
            public Request.Priority getPriority() {
                return Priority.IMMEDIATE;
            }
        };

        jsonArrayRequest.setRetryPolicy(new
                DefaultRetryPolicy(
                timeOut,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueueSingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);
    }
}
