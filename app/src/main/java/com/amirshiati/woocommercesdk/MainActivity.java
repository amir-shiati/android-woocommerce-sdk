package com.amirshiati.woocommercesdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.amirshiati.androidwoocommercesdk.WooSDK;
import com.amirshiati.androidwoocommercesdk.builder.CategoryBuilder;
import com.amirshiati.androidwoocommercesdk.builder.OrderBuilder;
import com.amirshiati.androidwoocommercesdk.builder.ProductBuilder;
import com.amirshiati.androidwoocommercesdk.enums.OrderStatus;
import com.amirshiati.androidwoocommercesdk.helper.UriBuilderSingleton;
import com.amirshiati.androidwoocommercesdk.interfaces.OnResponse;
import com.amirshiati.androidwoocommercesdk.interfaces.ParamBuilder;
import com.amirshiati.androidwoocommercesdk.model.Category;
import com.amirshiati.androidwoocommercesdk.model.Order;
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

        wooSDK.getOrder(843, new OnResponse() {
            @Override
            public void onSuccess(Object object) {
                Order order = (Order) object;
                Log.i(TAG, String.valueOf(order.getId()));
            }

            @Override
            public void onFail(String err) {

            }
        });

        ParamBuilder paramBuilder = new OrderBuilder().exclude(new int[]{843});

        wooSDK.getOrders(paramBuilder, new OnResponse() {
            @Override
            public void onSuccess(Object object) {
                ArrayList<Order> orders = (ArrayList<Order>) object;
                for (Order order : orders)
                    Log.i(TAG, String.valueOf(order.getId()));
            }

            @Override
            public void onFail(String err) {

            }
        });


        wooSDK.getProduct(841, new OnResponse() {
            @Override
            public void onSuccess(Object object) {
                Product product = (Product) object;
                Log.i(TAG, product.getName());
            }

            @Override
            public void onFail(String err) {

            }
        });

        ProductBuilder productBuilder = new ProductBuilder().perPage(5);

        wooSDK.getProducts(productBuilder, new OnResponse() {
            @Override
            public void onSuccess(Object object) {
                ArrayList<Product> products = (ArrayList<Product>) object;
                for (Product product : products)
                    Log.i(TAG, String.valueOf(product.getName()));
            }

            @Override
            public void onFail(String err) {

            }
        });

        wooSDK.getCategory(172, new OnResponse() {
            @Override
            public void onSuccess(Object object) {
                Category category = (Category) object;
                Log.i(TAG, category.getName());
            }

            @Override
            public void onFail(String err) {

            }
        });

        CategoryBuilder categoryBuilder = new CategoryBuilder().setPerPage(100);
        wooSDK.getCategories(categoryBuilder, new OnResponse() {
            @Override
            public void onSuccess(Object object) {
                ArrayList<Category> categories = (ArrayList<Category>) object;
                for (Category category : categories)
                    Log.i(TAG, String.valueOf(category.getName()));
            }

            @Override
            public void onFail(String err) {

            }
        });

    }
}