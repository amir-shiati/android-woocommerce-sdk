package com.amirshiati.androidwoocommercesdk.helper;

import android.net.Uri;

public class UriBuilder {

    public static Uri.Builder getProducts(String domainName) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(domainName)
                .appendPath("wp-json")
                .appendPath("wc")
                .appendPath("v3")
                .appendPath("products");

        return builder;
    }

    public static Uri.Builder getProduct(String domainName, long id) {
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


    public static Uri.Builder getCategories(String domainName) {
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

    public static Uri.Builder getCategory(String domainName, long id) {
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


    public static Uri.Builder getAttributes(String domainName) {
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

    public static Uri.Builder getAttribute(String domainName, long id) {
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
}
