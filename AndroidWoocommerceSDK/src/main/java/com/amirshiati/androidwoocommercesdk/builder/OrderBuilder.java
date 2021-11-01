package com.amirshiati.androidwoocommercesdk.builder;

import android.net.Uri;

import com.amirshiati.androidwoocommercesdk.enums.OrderBy;
import com.amirshiati.androidwoocommercesdk.enums.OrderSort;
import com.amirshiati.androidwoocommercesdk.enums.OrderStatus;
import com.amirshiati.androidwoocommercesdk.helper.Utils;
import com.amirshiati.androidwoocommercesdk.interfaces.ParamBuilder;

public class OrderBuilder implements ParamBuilder {


    @Override
    public String buildParam(Uri.Builder builder) {

        String array = "";

        builder.appendQueryParameter("page", String.valueOf(page));
        builder.appendQueryParameter("per_page", String.valueOf(perPage));

        if (!Utils.stringEmpty(search))
            builder.appendQueryParameter("search", search);

        if (orderSort != null)
            builder.appendQueryParameter("orderSort", Utils.setBuilderOrder(orderSort));

        if (orderBy != null)
            builder.appendQueryParameter("orderby", Utils.setBuilderOrderBy(orderBy));

        if (offset != null)
            builder.appendQueryParameter("offset", String.valueOf(offset));

        if (customer != null)
            builder.appendQueryParameter("customer", String.valueOf(customer));

        if (product != null)
            builder.appendQueryParameter("product", String.valueOf(product));

        if (status != null)
            builder.appendQueryParameter("status", Utils.setBuilderOrderStatus(status));

        if (include != null)
            array += Utils.includeId(include, "include");

        if (exclude != null)
            array += Utils.includeId(exclude, "exclude");

        if (parent != null)
            array += Utils.includeId(parent, "parent");

        if (parentExclude != null)
            array += Utils.includeId(parentExclude, "parent_exclude");

        return builder.build().toString() + array;
    }

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

    public OrderBuilder customer(Integer customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder product(Integer product) {
        this.product = product;
        return this;
    }

    public OrderBuilder status(OrderStatus status) {
        this.status = status;
        return this;
    }

    public OrderBuilder page(int page) {
        this.page = page;
        return this;
    }

    public OrderBuilder perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public OrderBuilder search(String search) {
        this.search = search;
        return this;
    }

    public OrderBuilder include(int[] include) {
        this.include = include;
        return this;
    }

    public OrderBuilder exclude(int[] exclude) {
        this.exclude = exclude;
        return this;
    }

    public OrderBuilder offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public OrderBuilder orderSort(OrderSort orderSort) {
        this.orderSort = orderSort;
        return this;
    }

    public OrderBuilder orderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public OrderBuilder parentExclude(int[] parentExclude) {
        this.parentExclude = parentExclude;
        return this;
    }

    public OrderBuilder parent(int[] parent) {
        this.parent = parent;
        return this;

    }
}
