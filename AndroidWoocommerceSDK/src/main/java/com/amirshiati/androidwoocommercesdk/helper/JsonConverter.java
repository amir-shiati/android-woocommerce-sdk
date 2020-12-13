package com.amirshiati.androidwoocommercesdk.helper;

import com.amirshiati.androidwoocommercesdk.model.Product;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonConverter {

    public static Product jsonToProduct(JSONObject toConvert) throws JSONException {
        return new Product(toConvert.getLong("id"), toConvert.getString("name"),
                toConvert.getString("slug"), toConvert.getString("permalink")
        );
    }

}
