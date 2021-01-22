package com.amirshiati.androidwoocommercesdk.interfaces;

import com.amirshiati.androidwoocommercesdk.model.Order;


public interface OnGetOrderFinished {

    void onSuccess(Order order);

    void onFail(String message);

}
