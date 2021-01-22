package com.amirshiati.androidwoocommercesdk;

import android.net.Uri;

import com.amirshiati.androidwoocommercesdk.enums.OrderSort;
import com.amirshiati.androidwoocommercesdk.enums.OrderBy;
import com.amirshiati.androidwoocommercesdk.enums.OrderManageType;
import com.amirshiati.androidwoocommercesdk.enums.OrderStatus;
import com.amirshiati.androidwoocommercesdk.helper.OrderJsonConverter;
import com.amirshiati.androidwoocommercesdk.helper.Utils;
import com.amirshiati.androidwoocommercesdk.helper.Volley;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonArrayFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonObjectFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetOrderFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetOrdersFinished;
import com.amirshiati.androidwoocommercesdk.model.Order;
import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class OrderManager {

    private Uri.Builder builder;
    private OrderManageType type;
    private Volley volley;

    private OnGetOrdersFinished onGetOrdersFinished;
    private OnGetOrderFinished onGetOrderFinished;
    private int page = 1;
    private int perPage = 10;
    private String search = "";
    private Integer offset;
    private OrderSort orderSort;
    private OrderBy orderBy;
    private OrderStatus status;
    private Integer customer;
    private Integer product;
    private int[] include;
    private int[] exclude;
    private int[] parent;
    private int[] parentExclude;

    public OrderManager(Uri.Builder builder, OrderManageType type, Volley volley) {
        this.builder = builder;
        this.type = type;
        this.volley = volley;
    }

    public OrderManager customer(Integer customer) {
        this.customer = customer;
        return this;
    }

    public OrderManager product(Integer product) {
        this.product = product;
        return this;
    }

    public OrderManager status(OrderStatus status) {
        this.status = status;
        return this;
    }

    public OrderManager addGetOrdersCallBack(OnGetOrdersFinished onGetOrdersFinished) {
        this.onGetOrdersFinished = onGetOrdersFinished;
        return this;
    }

    public OrderManager addGetOrderCallBack(OnGetOrderFinished onGetOrderFinished) {
        this.onGetOrderFinished = onGetOrderFinished;
        return this;
    }

    public OrderManager setPage(int page) {
        this.page = page;
        return this;
    }

    public OrderManager setPerPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public OrderManager search(String search) {
        this.search = search;
        return this;
    }

    public OrderManager setInclude(int[] include) {
        this.include = include;
        return this;
    }

    public OrderManager setExclude(int[] exclude) {
        this.exclude = exclude;
        return this;
    }

    public OrderManager setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public OrderManager setOrderSort(OrderSort orderSort) {
        this.orderSort = orderSort;
        return this;
    }

    public OrderManager setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public OrderManager setParentExclude(int[] parentExclude) {
        this.parentExclude = parentExclude;
        return this;
    }

    public OrderManager setParent(int[] parent) {
        this.parent = parent;
        return this;
    }

    public void start() {
        switch (type) {
            case GETORDERS:
                getOrders(this, setBuilder(this));
                break;

            case GETORDER:
                setBuilder(this);
                getOrder(this);

            default:
                return;
        }
    }

    private String setBuilder(final OrderManager orderManager) {
        if (orderManager.type == OrderManageType.GETORDER)
            return orderManager.builder.build().toString();

        String array = "";

        orderManager.builder.appendQueryParameter("page", String.valueOf(orderManager.page));
        orderManager.builder.appendQueryParameter("per_page", String.valueOf(orderManager.perPage));

        if (!Utils.stringEmpty(orderManager.search))
            orderManager.builder.appendQueryParameter("search", orderManager.search);

        if (orderManager.orderSort != null)
            orderManager.builder.appendQueryParameter("orderSort", Utils.setBuilderOrder(orderManager.orderSort));

        if (orderManager.orderBy != null)
            orderManager.builder.appendQueryParameter("orderby", Utils.setBuilderOrderBy(orderManager.orderBy));

        if (orderManager.offset != null)
            orderManager.builder.appendQueryParameter("offset", String.valueOf(orderManager.offset));

        if (orderManager.customer != null)
            orderManager.builder.appendQueryParameter("customer", String.valueOf(orderManager.customer));

        if (orderManager.product != null)
            orderManager.builder.appendQueryParameter("product", String.valueOf(orderManager.product));

        if (orderManager.status != null)
            orderManager.builder.appendQueryParameter("status", Utils.setBuilderOrderStatus(orderManager.status));

        if (orderManager.include != null)
            array += Utils.includeId(orderManager.include, "include");

        if (orderManager.exclude != null)
            array += Utils.includeId(orderManager.exclude, "exclude");

        if (orderManager.parent != null)
            array += Utils.includeId(orderManager.parent, "parent");

        if (orderManager.parentExclude != null)
            array += Utils.includeId(orderManager.parentExclude, "parent_exclude");


        return orderManager.builder.build().toString() + array;

    }

    private void getOrders(final OrderManager orderManager, String url) {
        final ArrayList<Order> result = new ArrayList<Order>();

        volley.basicAuthJsonArrayReq(
                Request.Method.GET,
                url,
                null,
                new OnGetJsonArrayFinished() {
                    @Override
                    public void onSuccess(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++)
                                result.add(OrderJsonConverter.jsonToOrder(response.getJSONObject(i)));

                            if (orderManager.onGetOrdersFinished != null)
                                orderManager.onGetOrdersFinished.onSuccess(result);

                        } catch (Exception e) {
                            if (orderManager.onGetOrdersFinished != null)
                                orderManager.onGetOrdersFinished.onFail(" Error: " + e.getMessage());
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

                        if (orderManager.onGetOrdersFinished != null)
                            orderManager.onGetOrdersFinished.onFail(body);
                    }
                });
    }

    private void getOrder(final OrderManager orderManager) {
        volley.basicAuthJsonObjReq(
                Request.Method.GET,
                builder.build().toString(),
                null,
                new OnGetJsonObjectFinished() {
                    @Override
                    public void onSuccess(JSONObject response) {
                        try {
                            if (orderManager.onGetOrderFinished != null)
                                orderManager.onGetOrderFinished.onSuccess(OrderJsonConverter.jsonToOrder(response));

                        } catch (Exception e) {
                            if (orderManager.onGetOrderFinished != null)
                                orderManager.onGetOrderFinished.onFail(" Error: " + e.getMessage());
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

                        if (orderManager.onGetOrderFinished != null)
                            orderManager.onGetOrderFinished.onFail(body);
                    }
                });
    }

}
