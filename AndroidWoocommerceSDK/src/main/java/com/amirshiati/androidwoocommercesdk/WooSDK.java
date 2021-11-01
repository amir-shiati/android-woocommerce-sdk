package com.amirshiati.androidwoocommercesdk;


import android.content.Context;

import com.amirshiati.androidwoocommercesdk.enums.AttributeManagerType;
import com.amirshiati.androidwoocommercesdk.enums.CategoryManagerType;
import com.amirshiati.androidwoocommercesdk.enums.OrderManageType;
import com.amirshiati.androidwoocommercesdk.enums.ProductManagerType;
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

    public CategoryManager getCategories() {
        return new CategoryManager(UriBuilder.getCategories(domainName), CategoryManagerType.GETCATEGORIES, volley);
    }

    public CategoryManager getCategory(long categoryId) {
        return new CategoryManager(UriBuilder.getCategory(domainName, categoryId), CategoryManagerType.GETCATEGORY, volley);
    }

    public AttributeManager getAttributes() {
        return new AttributeManager(UriBuilder.getAttributes(domainName), AttributeManagerType.GETATTRIBUTES, volley);
    }

    public AttributeManager getAttributes(long attributeId) {
        return new AttributeManager(UriBuilder.getAttribute(domainName, attributeId), AttributeManagerType.GETATTRIBUTE, volley);
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

}
