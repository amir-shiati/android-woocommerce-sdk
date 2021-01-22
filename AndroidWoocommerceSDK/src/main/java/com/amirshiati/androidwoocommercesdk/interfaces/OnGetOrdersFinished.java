package com.amirshiati.androidwoocommercesdk.interfaces;

import com.amirshiati.androidwoocommercesdk.model.Order;

import java.util.ArrayList;

public interface OnGetOrdersFinished {

    void onSuccess(ArrayList<Order> orders);

    void onFail(String message);

}
