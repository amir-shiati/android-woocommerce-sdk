package com.amirshiati.androidwoocommercesdk;

import android.net.Uri;
import android.util.Log;

import com.amirshiati.androidwoocommercesdk.enums.Order;
import com.amirshiati.androidwoocommercesdk.enums.OrderBy;
import com.amirshiati.androidwoocommercesdk.enums.ProductManagerType;
import com.amirshiati.androidwoocommercesdk.helper.ProductJsonConverter;
import com.amirshiati.androidwoocommercesdk.helper.Utils;
import com.amirshiati.androidwoocommercesdk.helper.Volley;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonArrayFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonObjectFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetProductFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetProductsFinished;
import com.amirshiati.androidwoocommercesdk.model.Product;
import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ProductManager {

    private Uri.Builder builder;
    private ProductManagerType type;
    private Volley volley;

    private OnGetProductsFinished onGetProductsFinished;
    private OnGetProductFinished onGetProductFinished;
    private int page = 1;
    private int perPage = 10;
    private String search = "";
    private Order order;
    private OrderBy orderBy;
    private int[] include;
    private int[] exclude;
    private int[] parent;
    private int[] parentExclude;


    public ProductManager(Uri.Builder builder, ProductManagerType type, Volley volley) {
        this.builder = builder;
        this.type = type;
        this.volley = volley;
    }

    public ProductManager setInclude(int[] include) {
        this.include = include;
        return this;
    }

    public ProductManager setParentExclude(int[] parentExclude) {
        this.parentExclude = parentExclude;
        return this;
    }

    public ProductManager setParent(int[] parent) {
        this.parent = parent;
        return this;
    }

    public ProductManager setExclude(int[] exclude) {
        this.exclude = exclude;
        return this;
    }

    public ProductManager addGetProductsCallBack(OnGetProductsFinished onGetProductFinished) {
        this.onGetProductsFinished = onGetProductFinished;
        return this;
    }

    public ProductManager addGetProductCallBack(OnGetProductFinished onGetProductFinished) {
        this.onGetProductFinished = onGetProductFinished;
        return this;
    }

    public ProductManager setPage(int page) {
        this.page = page;
        return this;
    }

    public ProductManager setPerPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public ProductManager setOrder(Order order) {
        this.order = order;
        return this;
    }

    public ProductManager setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public ProductManager search(String search) {
        this.search = search;
        return this;
    }

    public void start() {
        switch (type) {
            case GETPRODUCTS:
                getProducts(this, setBuilder(this));
                break;

            case GETPRODUCT:
                setBuilder(this);
                getProduct(this);

            default:
                return;
        }
    }

    private String setBuilder(final ProductManager productManager) {
        if (productManager.type == ProductManagerType.GETPRODUCT)
            return productManager.builder.build().toString();

        String array = "";

        productManager.builder.appendQueryParameter("page", String.valueOf(productManager.page));
        productManager.builder.appendQueryParameter("per_page", String.valueOf(productManager.perPage));

        if (!Utils.stringEmpty(productManager.search))
            productManager.builder.appendQueryParameter("search", productManager.search);

        if (productManager.order != null)
            productManager.builder.appendQueryParameter("order", Utils.setBuilderOrder(productManager.order));

        if (productManager.orderBy != null)
            productManager.builder.appendQueryParameter("orderby", Utils.setBuilderOrderBy(productManager.orderBy));

        if (productManager.include != null)
            array += Utils.includeId(productManager.include, "include");

        if (productManager.exclude != null)
            array += Utils.includeId(productManager.exclude, "exclude");

        if (productManager.parent != null)
            array += Utils.includeId(productManager.parent, "parent");

        if (productManager.parentExclude != null)
            array += Utils.includeId(productManager.parentExclude, "parent_exclude");


        return productManager.builder.build().toString() + array;

    }


    private void getProducts(final ProductManager productManager, String url) {
        Log.i("AAA", url);
        final ArrayList<Product> result = new ArrayList<Product>();

        volley.basicAuthJsonArrayReq(
                Request.Method.GET,
                url,
                null,
                new OnGetJsonArrayFinished() {
                    @Override
                    public void onSuccess(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++)
                                result.add(ProductJsonConverter.jsonToProduct(response.getJSONObject(i)));

                            if (productManager.onGetProductsFinished != null)
                                productManager.onGetProductsFinished.onSuccess(result);

                        } catch (Exception e) {
                            if (productManager.onGetProductsFinished != null)
                                productManager.onGetProductsFinished.onFail(" Error: " + e.getMessage());
                        }
                    }

                    @Override
                    public void onFail(VolleyError error) {
                        error.printStackTrace();
                        String body = "";
                        //String statusCode = String.valueOf(error.networkResponse.statusCode);
                        if (error.networkResponse.data != null) {
                            try {
                                body = new String(error.networkResponse.data, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }

                        if (productManager.onGetProductsFinished != null)
                            productManager.onGetProductsFinished.onFail(body);
                    }
                });
    }

    private void getProduct(final ProductManager productManager) {
        volley.basicAuthJsonObjReq(
                Request.Method.GET,
                builder.build().toString(),
                null,
                new OnGetJsonObjectFinished() {
                    @Override
                    public void onSuccess(JSONObject response) {
                        try {
                            Log.i("AAA", response.toString());
                            if (productManager.onGetProductFinished != null)
                                productManager.onGetProductFinished.onSuccess(ProductJsonConverter.jsonToProduct(response));

                        } catch (Exception e) {
                            if (productManager.onGetProductFinished != null)
                                productManager.onGetProductFinished.onFail(" Error: " + e.getMessage());
                        }
                    }

                    @Override
                    public void onFail(VolleyError error) {
                        error.printStackTrace();
                        String body = "";
                        //String statusCode = String.valueOf(error.networkResponse.statusCode);
                        if (error.networkResponse.data != null) {
                            try {
                                body = new String(error.networkResponse.data, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }

                        if (productManager.onGetProductFinished != null)
                            productManager.onGetProductFinished.onFail(body);
                    }
                });
    }
}


