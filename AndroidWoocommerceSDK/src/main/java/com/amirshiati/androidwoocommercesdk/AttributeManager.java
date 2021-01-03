package com.amirshiati.androidwoocommercesdk;

import android.net.Uri;

import com.amirshiati.androidwoocommercesdk.enums.AttributeManagerType;
import com.amirshiati.androidwoocommercesdk.enums.AttributeOrderBy;
import com.amirshiati.androidwoocommercesdk.enums.CategoryManagerType;
import com.amirshiati.androidwoocommercesdk.helper.AttributeJsonConverter;
import com.amirshiati.androidwoocommercesdk.helper.CategoryJsonConverter;
import com.amirshiati.androidwoocommercesdk.helper.Utils;
import com.amirshiati.androidwoocommercesdk.helper.Volley;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetAttributeFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetAttributesFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonArrayFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonObjectFinished;
import com.amirshiati.androidwoocommercesdk.model.Attribute;
import com.amirshiati.androidwoocommercesdk.model.Category;
import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AttributeManager {

    private Uri.Builder builder;
    private AttributeManagerType type;
    private Volley volley;

    private OnGetAttributesFinished onGetAttributesFinished;
    private OnGetAttributeFinished onGetAttributeFinished;

    public AttributeManager(Uri.Builder builder, AttributeManagerType type, Volley volley) {
        this.builder = builder;
        this.type = type;
        this.volley = volley;
    }

    public AttributeManager addGetAttributesCallBack(OnGetAttributesFinished onGetAttributesFinished) {
        this.onGetAttributesFinished = onGetAttributesFinished;
        return this;
    }

    public AttributeManager addGetAttributeCallBack(OnGetAttributeFinished onGetAttributeFinished) {
        this.onGetAttributeFinished = onGetAttributeFinished;
        return this;
    }

    public void start() {
        switch (type) {
            case GETATTRIBUTES:
                getAttributes(this, setBuilder(this));
                break;

            case GETATTRIBUTE:
                getAttribute(this);

            default:
                return;
        }
    }

    private String setBuilder(final AttributeManager attributeManager) {

        return attributeManager.builder.build().toString();

    }

    private void getAttributes(final AttributeManager attributeManager, String url) {
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

                            if (attributeManager.onGetAttributesFinished != null)
                                attributeManager.onGetAttributesFinished.onSuccess(result);

                        } catch (Exception e) {
                            if (attributeManager.onGetAttributesFinished != null)
                                attributeManager.onGetAttributesFinished.onFail(" Error: " + e.getMessage());
                        }
                    }

                    @Override
                    public void onFail(VolleyError error) {
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

                        if (attributeManager.onGetAttributesFinished != null)
                            attributeManager.onGetAttributesFinished.onFail(body);
                    }
                });
    }

    private void getAttribute(final AttributeManager attributeManager) {
        volley.basicAuthJsonObjReq(
                Request.Method.GET,
                builder.build().toString(),
                null,
                new OnGetJsonObjectFinished() {
                    @Override
                    public void onSuccess(JSONObject response) {
                        try {
                            if (attributeManager.onGetAttributeFinished != null)
                                attributeManager.onGetAttributeFinished.onSuccess(AttributeJsonConverter.jsonToAttribute(response));

                        } catch (Exception e) {
                            if (attributeManager.onGetAttributeFinished != null)
                                attributeManager.onGetAttributeFinished.onFail(" Error: " + e.getMessage());
                        }
                    }

                    @Override
                    public void onFail(VolleyError error) {
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

                        if (attributeManager.onGetAttributeFinished != null)
                            attributeManager.onGetAttributeFinished.onFail(body);
                    }
                });
    }
}
