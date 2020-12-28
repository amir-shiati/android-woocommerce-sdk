package com.amirshiati.woocommercesdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amirshiati.androidwoocommercesdk.WooSDK;
import com.amirshiati.androidwoocommercesdk.enums.Order;
import com.amirshiati.androidwoocommercesdk.enums.OrderBy;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetCategoriesFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetCategoryFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetProductFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetProductsFinished;
import com.amirshiati.androidwoocommercesdk.model.Category;
import com.amirshiati.androidwoocommercesdk.model.Image;
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

//        wooSDK.getCategory(191)
//                .addGetCategoryCallBack(new OnGetCategoryFinished() {
//                    @Override
//                    public void onSuccess(Category category) {
//                        Log.i(TAG, category.getName());
//                    }
//
//                    @Override
//                    public void onFail(String message) {
//                        Log.i(TAG, "error");
//                        Log.i(TAG, message);
//                    }
//                })
//                .start();

//        wooSDK.getCategories()
//                .setPage(1)
//                .setPerPage(100)
//                .setExclude(new int[200])
//                .setExclude(new int[]{201})
//                .setParent(323)
//                .setOrder(Order.DESC)
//                .hideEmpty(true)
//                .addGetCategoriesCallBack(new OnGetCategoriesFinished() {
//                    @Override
//                    public void onSuccess(ArrayList<Category> categories) {
//                        for (Category category : categories)
//                            Log.i(TAG, category.getName());
//                    }
//
//                    @Override
//                    public void onFail(String message) {
//                        Log.i(TAG, "error");
//                        Log.i(TAG, message);
//                    }
//                })
//                .start();

//        wooSDK.getProducts()
//                .setPage(1)
//                .setPerPage(100)
//                .featured(true)
//                .addGetProductsCallBack(new OnGetProductsFinished() {
//                    @Override
//                    public void onSuccess(ArrayList<Product> products) {
//                        for (Product product : products)
//                            Log.i(TAG, product.getName());
//                    }
//
//                    @Override
//                    public void onFail(String message) {
//                        Log.i(TAG, "error");
//                        Log.i(TAG, message);
//                    }
//                })
//
//                .start();

//        wooSDK.getProduct(494)
//                .addGetProductCallBack(new OnGetProductFinished() {
//                    @Override
//                    public void onSuccess(Product product) {
//                        for (Image image : product.getImages())
//                            Log.i(TAG, image.getSrc());
//                    }
//
//                    @Override
//                    public void onFail(String message) {
//                        Log.i(TAG, "error");
//                        Log.i(TAG, message);
//                    }
//                })
//                .start();

    }
}