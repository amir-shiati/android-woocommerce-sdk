package com.amirshiati.androidwoocommercesdk;


import android.content.Context;
import android.os.Build;
import android.util.Base64;

import com.amirshiati.androidwoocommercesdk.helper.JsonConverter;
import com.amirshiati.androidwoocommercesdk.helper.RequestQueueSingleton;
import com.amirshiati.androidwoocommercesdk.helper.UriBuilder;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetProductsFinished;
import com.amirshiati.androidwoocommercesdk.model.Product;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WooSDK {

    private Context context;
    private String ckKey;
    private String csKey;
    private String domainName;

    private int timeOut = 10000;

    public WooSDK(Context context, String ckKey, String csKey, String domainName) {
        this.context = context;
        this.ckKey = ckKey;
        this.csKey = csKey;
        this.domainName = domainName;
    }

    public void getProducts(long page, long perPage, OnGetProductsFinished onGetProductFinished) {
        final ArrayList<Product> result = new ArrayList<Product>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, UriBuilder.getProducts(domainName, page, perPage), null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    for (int i = 0; i < response.length(); i++)
                        result.add(JsonConverter.jsonToProduct(response.getJSONObject(i)));

                    onGetProductFinished.onSuccess(result);

                } catch (Exception e) {
                    onGetProductFinished.onFail(e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                String body = "";
                //String statusCode = String.valueOf(error.networkResponse.statusCode);
                if (error.networkResponse.data != null) {
                    try {
                        body = new String(error.networkResponse.data, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

                onGetProductFinished.onFail(body);

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
