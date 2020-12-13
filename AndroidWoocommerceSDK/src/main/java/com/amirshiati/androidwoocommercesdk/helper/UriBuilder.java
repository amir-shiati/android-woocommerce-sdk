package com.amirshiati.androidwoocommercesdk.helper;

import android.net.Uri;

public class UriBuilder {

    public static String getProducts(String domainName, long page, long perPage) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(domainName)
                .appendPath("wp-json")
                .appendPath("wc")
                .appendPath("v3")
                .appendPath("products")
                .appendQueryParameter("page", String.valueOf(page))
                .appendQueryParameter("per_page", String.valueOf(perPage));

        return builder.build().toString();
    }
}
