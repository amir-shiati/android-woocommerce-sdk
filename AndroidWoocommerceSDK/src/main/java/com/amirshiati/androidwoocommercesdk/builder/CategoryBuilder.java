package com.amirshiati.androidwoocommercesdk.builder;

import android.net.Uri;

import com.amirshiati.androidwoocommercesdk.enums.CategoryOrderBy;
import com.amirshiati.androidwoocommercesdk.enums.OrderSort;
import com.amirshiati.androidwoocommercesdk.helper.Utils;
import com.amirshiati.androidwoocommercesdk.interfaces.ParamBuilder;

public class CategoryBuilder implements ParamBuilder {
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
            builder.appendQueryParameter("orderby", Utils.setBuilderCategoryOrderBy(orderBy));

        if (hideEmpty != null)
            builder.appendQueryParameter("hide_empty", String.valueOf(hideEmpty));

        if (parent != null)
            builder.appendQueryParameter("parent", String.valueOf(parent));

        if (product != null)
            builder.appendQueryParameter("product", String.valueOf(product));

        if (!Utils.stringEmpty(slug))
            builder.appendQueryParameter("slug", slug);

        if (include != null)
            array += Utils.includeId(include, "include");

        if (exclude != null)
            array += Utils.includeId(exclude, "exclude");


        return builder.build().toString() + array;

    }

    private int page = 1;
    private int perPage = 10;
    private String search;
    private OrderSort orderSort;
    private CategoryOrderBy orderBy;
    private Boolean hideEmpty;
    private Long parent;
    private Long product;
    private String slug;
    private int[] include;
    private int[] exclude;
    

    public CategoryBuilder setPage(int page) {
        this.page = page;
        return this;
    }

    public CategoryBuilder setPerPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public CategoryBuilder search(String search) {
        this.search = search;
        return this;
    }

    public CategoryBuilder setOrderSort(OrderSort orderSort) {
        this.orderSort = orderSort;
        return this;
    }

    public CategoryBuilder setOrderBy(CategoryOrderBy orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public CategoryBuilder hideEmpty(boolean hideEmpty) {
        this.hideEmpty = hideEmpty;
        return this;
    }

    public CategoryBuilder setParent(long parent) {
        this.parent = parent;
        return this;
    }

    public CategoryBuilder setProduct(long product) {
        this.product = product;
        return this;
    }

    public CategoryBuilder slug(String slug) {
        this.slug = slug;
        return this;
    }

    public CategoryBuilder setInclude(int[] include) {
        this.include = include;
        return this;
    }

    public CategoryBuilder setExclude(int[] exclude) {
        this.exclude = exclude;
        return this;
    }
}
