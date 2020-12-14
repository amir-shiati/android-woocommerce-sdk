package com.amirshiati.woocommercesdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amirshiati.androidwoocommercesdk.WooSDK;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetProductsFinished;
import com.amirshiati.androidwoocommercesdk.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WooSDK wooSDK = new WooSDK(this,
                "ck_40d3e92eeff1eb8d6df19ddc9a5d72add570c41a",
                "cs_87214e0b3128b84792407443077db0090bad8967",
                "testforapp.webgram.app");


        wooSDK.productManager.getProducts(1, 15, new OnGetProductsFinished() {
            @Override
            public void onSuccess(ArrayList<Product> products) {
                for (Product product : products)
                    Log.i(TAG, product.getName());
            }

            @Override
            public void onFail(String message) {
                Log.i(TAG, message);
            }
        });
    }
}