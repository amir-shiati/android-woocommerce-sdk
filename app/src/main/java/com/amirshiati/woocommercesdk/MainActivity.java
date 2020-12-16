package com.amirshiati.woocommercesdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amirshiati.androidwoocommercesdk.WooSDK;
import com.amirshiati.androidwoocommercesdk.enums.Order;
import com.amirshiati.androidwoocommercesdk.enums.OrderBy;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetProductsFinished;
import com.amirshiati.androidwoocommercesdk.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WooSDK wooSDK = new WooSDK(
                this,
                "ck_key",
                "cs_key",
                "domain"
        );

        wooSDK.getProducts()
                .setPage(3)
                .setPerPage(25)
                .search("Hoodie")
                .setOrder(Order.ASC)
                .setOrderBy(OrderBy.SLUG)

                .addCallBack(new OnGetProductsFinished() {
                    @Override
                    public void onSuccess(ArrayList<Product> products) {
                        for (Product product : products)
                            Log.i(TAG, product.getName());
                    }

                    @Override
                    public void onFail(String message) {
                        Log.i(TAG, message);
                    }
                })

                .start();

    }
}