package com.amirshiati.androidwoocommercesdk.builder;

import android.net.Uri;

import com.amirshiati.androidwoocommercesdk.interfaces.ParamBuilder;

public class AttributeBuilder implements ParamBuilder {
    @Override
    public String buildParam(Uri.Builder builder) {
        return builder.build().toString();
    }
}
