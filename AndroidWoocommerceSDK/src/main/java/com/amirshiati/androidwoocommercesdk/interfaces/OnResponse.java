package com.amirshiati.androidwoocommercesdk.interfaces;

public interface OnResponse<T> {

    void onSuccess(T object);

    void onFail(String err);
}
