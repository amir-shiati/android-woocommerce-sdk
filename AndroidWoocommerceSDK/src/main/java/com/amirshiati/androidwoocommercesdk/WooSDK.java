package com.amirshiati.androidwoocommercesdk;


import android.content.Context;

import com.amirshiati.androidwoocommercesdk.enums.CategoryManagerType;
import com.amirshiati.androidwoocommercesdk.enums.ProductManagerType;
import com.amirshiati.androidwoocommercesdk.helper.ProductJsonConverter;
import com.amirshiati.androidwoocommercesdk.helper.UriBuilder;
import com.amirshiati.androidwoocommercesdk.helper.Volley;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonArrayFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetProductsFinished;
import com.amirshiati.androidwoocommercesdk.model.Product;
import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class WooSDK {

    private Context context;
    private String ckKey;
    private String csKey;
    private String domainName;

    private int timeOut = 10000;

    private Volley volley;

    public WooSDK(Context context, String ckKey, String csKey, String domainName) {
        this.context = context;
        this.ckKey = ckKey;
        this.csKey = csKey;
        this.domainName = domainName;

        volley = new Volley(context, ckKey, csKey, timeOut);
    }

    public ProductManager getProducts() {
        return new ProductManager(UriBuilder.getProducts(domainName), ProductManagerType.GETPRODUCTS, volley);
    }

    public ProductManager getProduct(long productID) {
        return new ProductManager(UriBuilder.getProduct(domainName, productID), ProductManagerType.GETPRODUCT, volley);
    }

    public CategoryManager getCategories() {
        return new CategoryManager(UriBuilder.getCategories(domainName), CategoryManagerType.GETCATEGORIES, volley);
    }

    public CategoryManager getCategory(long categoryId) {
        return new CategoryManager(UriBuilder.getCategory(domainName, categoryId), CategoryManagerType.GETCATEGORY, volley);
    }

}
