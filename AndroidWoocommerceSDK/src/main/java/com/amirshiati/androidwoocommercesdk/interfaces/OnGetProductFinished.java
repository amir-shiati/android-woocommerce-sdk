package com.amirshiati.androidwoocommercesdk.interfaces;

import com.amirshiati.androidwoocommercesdk.model.Product;


public interface OnGetProductFinished {

    void onSuccess(Product product);

    void onFail(String message);

}
