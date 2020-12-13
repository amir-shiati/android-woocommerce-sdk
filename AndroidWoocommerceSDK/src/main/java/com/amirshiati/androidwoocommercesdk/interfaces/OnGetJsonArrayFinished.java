package com.amirshiati.androidwoocommercesdk.interfaces;

import com.android.volley.VolleyError;

import org.json.JSONArray;

public interface OnGetJsonArrayFinished {

    void onSuccess(JSONArray response);

    void onFail(VolleyError error);
}
