package com.amirshiati.androidwoocommercesdk;

import android.net.Uri;

import com.amirshiati.androidwoocommercesdk.enums.OrderSort;
import com.amirshiati.androidwoocommercesdk.enums.OrderBy;
import com.amirshiati.androidwoocommercesdk.enums.ProductManagerType;
import com.amirshiati.androidwoocommercesdk.enums.ProductStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductStockStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductType;
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


    public ProductManager(Uri.Builder builder, ProductManagerType type, Volley volley) {
        this.builder = builder;
        this.type = type;
        this.volley = volley;
    }

    public ProductManager stockStatus(ProductStockStatus stockStatus) {
        this.stockStatus = stockStatus;
        return this;
    }

    public ProductManager maxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public ProductManager setStatus(ProductStatus status) {
        this.status = status;
        return this;
    }

    public ProductManager setAttributeTerm(String attributeTerm) {
        this.attributeTerm = attributeTerm;
        return this;
    }

    public ProductManager minPrice(String minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public ProductManager onSale(boolean onSale) {
        this.onSale = onSale;
        return this;
    }

    public ProductManager taxClass(String taxClass) {
        this.taxClass = taxClass;
        return this;
    }

    public ProductManager attribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    public ProductManager shippingClass(String shippingClass) {
        this.shippingClass = shippingClass;
        return this;
    }

    public ProductManager tag(String tag) {
        this.tag = tag;
        return this;
    }

    public ProductManager category(String category) {
        this.category = category;
        return this;
    }

    public ProductManager featured(boolean featured) {
        this.featured = featured;
        return this;
    }

    public ProductManager sku(String sku) {
        this.sku = sku;
        return this;
    }

    public ProductManager type(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public ProductManager slug(String slug) {
        this.slug = slug;
        return this;
    }

    public ProductManager setOffset(Integer offset) {
        this.offset = offset;
        return this;
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

    public ProductManager setOrderSort(OrderSort orderSort) {
        this.orderSort = orderSort;
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

        if (productManager.orderSort != null)
            productManager.builder.appendQueryParameter("orderSort", Utils.setBuilderOrder(productManager.orderSort));

        if (productManager.orderBy != null)
            productManager.builder.appendQueryParameter("orderby", Utils.setBuilderOrderBy(productManager.orderBy));

        if (productManager.offset != null)
            productManager.builder.appendQueryParameter("offset", String.valueOf(productManager.offset));

        if (!Utils.stringEmpty(productManager.slug))
            productManager.builder.appendQueryParameter("slug", productManager.slug);

        if (productManager.status != null)
            productManager.builder.appendQueryParameter("status", Utils.setBuilderProductStatus(productManager.status));

        if (productManager.productType != null)
            productManager.builder.appendQueryParameter("type", Utils.setBuilderProductType(productManager.productType));

        if (!Utils.stringEmpty(productManager.sku))
            productManager.builder.appendQueryParameter("sku", productManager.sku);

        if (productManager.featured != null)
            productManager.builder.appendQueryParameter("featured", String.valueOf(productManager.featured));

        if (!Utils.stringEmpty(productManager.category))
            productManager.builder.appendQueryParameter("category", productManager.category);

        if (!Utils.stringEmpty(productManager.tag))
            productManager.builder.appendQueryParameter("tag", productManager.tag);

        if (!Utils.stringEmpty(productManager.shippingClass))
            productManager.builder.appendQueryParameter("shipping_class", productManager.shippingClass);

        if (!Utils.stringEmpty(productManager.attribute))
            productManager.builder.appendQueryParameter("attribute", productManager.attribute);

        if (!Utils.stringEmpty(productManager.attributeTerm))
            productManager.builder.appendQueryParameter("attribute_term", productManager.attributeTerm);

        if (!Utils.stringEmpty(productManager.taxClass))
            productManager.builder.appendQueryParameter("tax_class", productManager.taxClass);

        if (productManager.onSale != null)
            productManager.builder.appendQueryParameter("on_sale", String.valueOf(productManager.onSale));

        if (!Utils.stringEmpty(productManager.attributeTerm))
            productManager.builder.appendQueryParameter("attribute_term", productManager.attributeTerm);

        if (!Utils.stringEmpty(productManager.minPrice))
            productManager.builder.appendQueryParameter("min_price", productManager.minPrice);

        if (!Utils.stringEmpty(productManager.maxPrice))
            productManager.builder.appendQueryParameter("max_price", productManager.maxPrice);

        if (productManager.stockStatus != null)
            productManager.builder.appendQueryParameter("stock_status", Utils.setBuilderProductStockStatus(productManager.stockStatus));


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


