package com.amirshiati.androidwoocommercesdk.helper;

import android.net.Uri;

public class UriBuilderSingleton {

    private static UriBuilderSingleton instance;

    private String domainName;

    private UriBuilderSingleton(String domainName) {
        this.domainName = domainName;
    }

    public static synchronized UriBuilderSingleton getInstance(String domainName) {
        return instance == null ? instance = new UriBuilderSingleton(domainName) : instance;
    }

    public Uri.Builder getProducts() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(domainName)
                .appendPath("wp-json")
                .appendPath("wc")
                .appendPath("v3")
                .appendPath("products");

        return builder;
    }

    public Uri.Builder getProduct(long id) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(domainName)
                .appendPath("wp-json")
                .appendPath("wc")
                .appendPath("v3")
                .appendPath("products")
                .appendPath(String.valueOf(id));

        return builder;
    }


    public Uri.Builder getCategories() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(domainName)
                .appendPath("wp-json")
                .appendPath("wc")
                .appendPath("v3")
                .appendPath("products")
                .appendPath("categories");

        return builder;
    }

    public Uri.Builder getCategory(long id) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(domainName)
                .appendPath("wp-json")
                .appendPath("wc")
                .appendPath("v3")
                .appendPath("products")
                .appendPath("categories")
                .appendPath(String.valueOf(id));

        return builder;
    }


    public Uri.Builder getAttributes() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(domainName)
                .appendPath("wp-json")
                .appendPath("wc")
                .appendPath("v3")
                .appendPath("products")
                .appendPath("attributes");

        return builder;
    }

    public Uri.Builder getAttribute(long id) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(domainName)
                .appendPath("wp-json")
                .appendPath("wc")
                .appendPath("v3")
                .appendPath("products")
                .appendPath("attributes")
                .appendPath(String.valueOf(id));

        return builder;
    }

    public Uri.Builder getOrders() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(domainName)
                .appendPath("wp-json")
                .appendPath("wc")
                .appendPath("v3")
                .appendPath("orders");

        return builder;
    }

    public Uri.Builder getOrder(long id) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(domainName)
                .appendPath("wp-json")
                .appendPath("wc")
                .appendPath("v3")
                .appendPath("orders")
                .appendPath(String.valueOf(id));

        return builder;
    }
}
