package com.amirshiati.androidwoocommercesdk.interfaces;

import com.amirshiati.androidwoocommercesdk.model.Product;

import java.util.ArrayList;

public interface OnGetProductsFinished {

    void onSuccess(ArrayList<Product> products);

    void onFail(String message);

}
