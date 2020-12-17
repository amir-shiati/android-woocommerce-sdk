package com.amirshiati.androidwoocommercesdk.interfaces;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface OnGetJsonObjectFinished {

    void onSuccess(JSONObject response);

    void onFail(VolleyError error);

}
