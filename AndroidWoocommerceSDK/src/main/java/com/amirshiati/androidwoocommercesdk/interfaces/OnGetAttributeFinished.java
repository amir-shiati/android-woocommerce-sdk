package com.amirshiati.androidwoocommercesdk.interfaces;

import com.amirshiati.androidwoocommercesdk.model.Attribute;

import java.util.ArrayList;

public interface OnGetAttributeFinished {

    void onSuccess(Attribute attribute);

    void onFail(String message);

}
