package com.amirshiati.androidwoocommercesdk.builder;

import android.net.Uri;

import com.amirshiati.androidwoocommercesdk.enums.OrderBy;
import com.amirshiati.androidwoocommercesdk.enums.OrderSort;
import com.amirshiati.androidwoocommercesdk.enums.ProductStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductStockStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductType;
import com.amirshiati.androidwoocommercesdk.helper.Utils;
import com.amirshiati.androidwoocommercesdk.interfaces.ParamBuilder;

public class ProductBuilder implements ParamBuilder {
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

        if (!Utils.stringEmpty(slug))
            builder.appendQueryParameter("slug", slug);

        if (status != null)
            builder.appendQueryParameter("status", Utils.setBuilderProductStatus(status));

        if (productType != null)
            builder.appendQueryParameter("type", Utils.setBuilderProductType(productType));

        if (!Utils.stringEmpty(sku))
            builder.appendQueryParameter("sku", sku);

        if (featured != null)
            builder.appendQueryParameter("featured", String.valueOf(featured));

        if (!Utils.stringEmpty(category))
            builder.appendQueryParameter("category", category);

        if (!Utils.stringEmpty(tag))
            builder.appendQueryParameter("tag", tag);

        if (!Utils.stringEmpty(shippingClass))
            builder.appendQueryParameter("shipping_class", shippingClass);

        if (!Utils.stringEmpty(attribute))
            builder.appendQueryParameter("attribute", attribute);

        if (!Utils.stringEmpty(attributeTerm))
            builder.appendQueryParameter("attribute_term", attributeTerm);

        if (!Utils.stringEmpty(taxClass))
            builder.appendQueryParameter("tax_class", taxClass);

        if (onSale != null)
            builder.appendQueryParameter("on_sale", String.valueOf(onSale));

        if (!Utils.stringEmpty(attributeTerm))
            builder.appendQueryParameter("attribute_term", attributeTerm);

        if (!Utils.stringEmpty(minPrice))
            builder.appendQueryParameter("min_price", minPrice);

        if (!Utils.stringEmpty(maxPrice))
            builder.appendQueryParameter("max_price", maxPrice);

        if (stockStatus != null)
            builder.appendQueryParameter("stock_status", Utils.setBuilderProductStockStatus(stockStatus));


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
    private OrderSort orderSort;
    private OrderBy orderBy;
    private Integer offset;
    private String slug;
    private ProductStatus status;
    private ProductType productType;
    private String sku;
    private Boolean featured;
    private String category;
    private String tag;
    private String shippingClass;
    private String attribute;
    private String attributeTerm;
    private String taxClass;
    private Boolean onSale;
    private String minPrice;
    private String maxPrice;
    private ProductStockStatus stockStatus;
    private int[] include;
    private int[] exclude;
    private int[] parent;
    private int[] parentExclude;

    public ProductBuilder stockStatus(ProductStockStatus stockStatus) {
        this.stockStatus = stockStatus;
        return this;
    }

    public ProductBuilder maxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public ProductBuilder status(ProductStatus status) {
        this.status = status;
        return this;
    }

    public ProductBuilder attributeTerm(String attributeTerm) {
        this.attributeTerm = attributeTerm;
        return this;
    }

    public ProductBuilder minPrice(String minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public ProductBuilder onSale(boolean onSale) {
        this.onSale = onSale;
        return this;
    }

    public ProductBuilder taxClass(String taxClass) {
        this.taxClass = taxClass;
        return this;
    }

    public ProductBuilder attribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    public ProductBuilder shippingClass(String shippingClass) {
        this.shippingClass = shippingClass;
        return this;
    }

    public ProductBuilder tag(String tag) {
        this.tag = tag;
        return this;
    }

    public ProductBuilder category(String category) {
        this.category = category;
        return this;
    }

    public ProductBuilder featured(boolean featured) {
        this.featured = featured;
        return this;
    }

    public ProductBuilder sku(String sku) {
        this.sku = sku;
        return this;
    }

    public ProductBuilder type(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public ProductBuilder slug(String slug) {
        this.slug = slug;
        return this;
    }

    public ProductBuilder offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ProductBuilder include(int[] include) {
        this.include = include;
        return this;
    }

    public ProductBuilder parentExclude(int[] parentExclude) {
        this.parentExclude = parentExclude;
        return this;
    }

    public ProductBuilder parent(int[] parent) {
        this.parent = parent;
        return this;
    }

    public ProductBuilder exclude(int[] exclude) {
        this.exclude = exclude;
        return this;
    }

    public ProductBuilder page(int page) {
        this.page = page;
        return this;
    }

    public ProductBuilder perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public ProductBuilder orderSort(OrderSort orderSort) {
        this.orderSort = orderSort;
        return this;
    }

    public ProductBuilder orderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public ProductBuilder search(String search) {
        this.search = search;
        return this;
    }
}
