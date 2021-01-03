package com.amirshiati.androidwoocommercesdk.interfaces;

import com.amirshiati.androidwoocommercesdk.model.Attribute;

import java.util.ArrayList;

public interface OnGetAttributesFinished {

    void onSuccess(ArrayList<Attribute> attributes);

    void onFail(String message);

}
