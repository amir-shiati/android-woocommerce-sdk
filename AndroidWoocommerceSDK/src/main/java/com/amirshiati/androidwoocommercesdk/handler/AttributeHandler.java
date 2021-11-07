package com.amirshiati.androidwoocommercesdk.handler;

import com.amirshiati.androidwoocommercesdk.helper.UriBuilderSingleton;
import com.amirshiati.androidwoocommercesdk.helper.Utils;
import com.amirshiati.androidwoocommercesdk.helper.Volley;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonArrayFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonObjectFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnResponse;
import com.amirshiati.androidwoocommercesdk.interfaces.ParamBuilder;
import com.amirshiati.androidwoocommercesdk.interfaces.WooHandler;
import com.amirshiati.androidwoocommercesdk.json.AttributeJsonConverter;
import com.amirshiati.androidwoocommercesdk.model.Attribute;
import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AttributeHandler implements WooHandler {

    private UriBuilderSingleton uriBuilder;
    private Volley volley;


    public AttributeHandler(UriBuilderSingleton uriBuilder, Volley volley) {
        this.uriBuilder = uriBuilder;
        this.volley = volley;
    }

    @Override
    public void get(long id, OnResponse onResponse) {
        String url = uriBuilder.getAttribute(id).build().toString();
        volley.basicAuthJsonObjReq(Request.Method.GET, url, null, new OnGetJsonObjectFinished() {
            @Override
            public void onSuccess(JSONObject response) {
                try {
                    if (onResponse != null)
                        onResponse.onSuccess(AttributeJsonConverter.jsonToAttribute(response));

                } catch (Exception e) {
                    if (onResponse != null)
                        onResponse.onFail(" Error: " + e.getMessage());
                }
            }

            @Override
            public void onFail(VolleyError error) {
                if (onResponse != null)
                    onResponse.onFail(" Error: " + Utils.getVolleyErrorBody(error));
            }
        });
    }

    @Override
    public void getList(ParamBuilder builder, OnResponse onResponse) {
        String url = builder.buildParam(uriBuilder.getAttributes());
        final ArrayList<Attribute> result = new ArrayList<Attribute>();

        volley.basicAuthJsonArrayReq(
                Request.Method.GET,
                url,
                null,
                new OnGetJsonArrayFinished() {
                    @Override
                    public void onSuccess(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++)
                                result.add(AttributeJsonConverter.jsonToAttribute(response.getJSONObject(i)));

                            if (onResponse != null)
                                onResponse.onSuccess(result);

                        } catch (Exception e) {
                            if (onResponse != null)
                                onResponse.onFail(" Error: " + e.getMessage());
                        }
                    }

                    @Override
                    public void onFail(VolleyError error) {
                        if (onResponse != null)
                            onResponse.onFail(" Error: " + Utils.getVolleyErrorBody(error));
                    }
                });
    }

    @Override
    public void delete(ParamBuilder builder) {

    }

    @Override
    public void add(ParamBuilder builder) {

    }

    @Override
    public void update(ParamBuilder builder) {

    }
}
