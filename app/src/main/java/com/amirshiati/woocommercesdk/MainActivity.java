package com.amirshiati.woocommercesdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amirshiati.androidwoocommercesdk.WooSDK;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetOrdersFinished;
import com.amirshiati.androidwoocommercesdk.model.Order;

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

//        wooSDK.getOrders()
//                .addGetOrdersCallBack(new OnGetOrdersFinished() {
//                    @Override
//                    public void onSuccess(ArrayList<Order> orders) {
//                        for (Order order : orders)
//                            Log.i(TAG, "order id : " + order.getId());
//                    }
//
//                    @Override
//                    public void onFail(String message) {
//                        Log.i(TAG, "error");
//                        Log.i(TAG, message);
//                    }
//                })
//                .start();

//        wooSDK.getAttributes(1)
//                .addGetAttributeCallBack(new OnGetAttributeFinished() {
//                    @Override
//                    public void onSuccess(Attribute attribute) {
//                        Log.i(TAG, attribute.getName());
//                    }
//
//                    @Override
//                    public void onFail(String message) {
//                        Log.i(TAG, "error");
//                        Log.i(TAG, message);
//                    }
//                })
//                .start();

//        wooSDK.getAttributes()
//                .addGetAttributesCallBack(new OnGetAttributesFinished() {
//                    @Override
//                    public void onSuccess(ArrayList<Attribute> attributes) {
//                        for (Attribute attribute : attributes)
//                            Log.i(TAG, attribute.getName());
//                    }
//
//                    @Override
//                    public void onFail(String message) {
//                        Log.i(TAG, "error");
//                        Log.i(TAG, message);
//                    }
//                })
//                .start();

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
//                .setOrderSort(OrderSort.DESC)
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