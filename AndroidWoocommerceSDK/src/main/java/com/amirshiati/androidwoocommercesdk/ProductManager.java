package com.amirshiati.androidwoocommercesdk;

import com.amirshiati.androidwoocommercesdk.helper.ProductJsonConverter;
import com.amirshiati.androidwoocommercesdk.helper.UriBuilder;
import com.amirshiati.androidwoocommercesdk.helper.Volley;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonArrayFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetProductsFinished;
import com.amirshiati.androidwoocommercesdk.model.Product;
import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ProductManager {

    private String domainName;
    private Volley volley;

    public ProductManager(String domainName, Volley volley) {
        this.domainName = domainName;
        this.volley = volley;
    }

    public void getProducts(long page, long perPage, OnGetProductsFinished onGetProductFinished) {
        final ArrayList<Product> result = new ArrayList<Product>();

        volley.basicAuthJsonArrayReq(
                Request.Method.GET,
                UriBuilder.getProducts(domainName, page, perPage),
                null,
                new OnGetJsonArrayFinished() {
                    @Override
                    public void onSuccess(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++)
                                result.add(ProductJsonConverter.jsonToProduct(response.getJSONObject(i)));

                            onGetProductFinished.onSuccess(result);

                        } catch (Exception e) {
                            onGetProductFinished.onFail(e.getMessage());
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

                        onGetProductFinished.onFail(body);
                    }
                });
    }
}
