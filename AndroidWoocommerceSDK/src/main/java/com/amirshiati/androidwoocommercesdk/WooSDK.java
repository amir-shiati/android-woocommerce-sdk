package com.amirshiati.androidwoocommercesdk;


import android.content.Context;

import com.amirshiati.androidwoocommercesdk.enums.AttributeManagerType;
import com.amirshiati.androidwoocommercesdk.enums.CategoryManagerType;
import com.amirshiati.androidwoocommercesdk.enums.OrderManageType;
import com.amirshiati.androidwoocommercesdk.enums.ProductManagerType;
import com.amirshiati.androidwoocommercesdk.handler.AttributeHandler;
import com.amirshiati.androidwoocommercesdk.handler.CategoryHandler;
import com.amirshiati.androidwoocommercesdk.handler.OrderHandler;
import com.amirshiati.androidwoocommercesdk.handler.ProductHandler;
import com.amirshiati.androidwoocommercesdk.helper.UriBuilder;
import com.amirshiati.androidwoocommercesdk.helper.UriBuilderSingleton;
import com.amirshiati.androidwoocommercesdk.helper.Volley;
import com.amirshiati.androidwoocommercesdk.interfaces.OnResponse;
import com.amirshiati.androidwoocommercesdk.interfaces.ParamBuilder;

public class WooSDK {

    private Context context;
    private String ckKey;
    private String csKey;
    private String domainName;

    private int timeOut = 10000;

    private Volley volley;
    private UriBuilderSingleton uriBuilderSingleton;

    public WooSDK(Context context, String ckKey, String csKey, String domainName) {
        this.context = context;
        this.ckKey = ckKey;
        this.csKey = csKey;
        this.domainName = domainName;

        volley = new Volley(context, ckKey, csKey, timeOut);
        uriBuilderSingleton = UriBuilderSingleton.getInstance(domainName);
    }

    public void getProduct(long id, OnResponse onResponse) {
        ProductHandler productHandler = new ProductHandler(uriBuilderSingleton, volley);
        productHandler.get(id, onResponse);
    }

    public void getProducts(ParamBuilder paramBuilder, OnResponse onResponse) {
        ProductHandler productHandler = new ProductHandler(uriBuilderSingleton, volley);
        productHandler.getList(paramBuilder, onResponse);
    }


    public void getOrder(long id, OnResponse onResponse) {
        OrderHandler orderHandler = new OrderHandler(uriBuilderSingleton, volley);
        orderHandler.get(id, onResponse);
    }

    public void getOrders(ParamBuilder paramBuilder, OnResponse onResponse) {
        OrderHandler orderHandler = new OrderHandler(uriBuilderSingleton, volley);
        orderHandler.getList(paramBuilder, onResponse);
    }

    public void getCategory(long id, OnResponse onResponse) {
        CategoryHandler categoryHandler = new CategoryHandler(uriBuilderSingleton, volley);
        categoryHandler.get(id, onResponse);
    }

    public void getCategories(ParamBuilder paramBuilder, OnResponse onResponse) {
        CategoryHandler categoryHandler = new CategoryHandler(uriBuilderSingleton, volley);
        categoryHandler.getList(paramBuilder, onResponse);
    }

    public void getAttribute(long id, OnResponse onResponse) {
        AttributeHandler attributeHandler = new AttributeHandler(uriBuilderSingleton, volley);
        attributeHandler.get(id, onResponse);
    }

    public void getAttributes(ParamBuilder paramBuilder, OnResponse onResponse) {
        AttributeHandler attributeHandler = new AttributeHandler(uriBuilderSingleton, volley);
        attributeHandler.getList(paramBuilder, onResponse);
    }


}
