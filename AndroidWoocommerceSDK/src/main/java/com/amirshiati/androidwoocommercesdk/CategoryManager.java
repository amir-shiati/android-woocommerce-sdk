package com.amirshiati.androidwoocommercesdk;

import android.net.Uri;
import android.util.Log;

import com.amirshiati.androidwoocommercesdk.enums.CategoryManagerType;
import com.amirshiati.androidwoocommercesdk.enums.Order;
import com.amirshiati.androidwoocommercesdk.enums.OrderBy;
import com.amirshiati.androidwoocommercesdk.enums.ProductManagerType;
import com.amirshiati.androidwoocommercesdk.helper.CategoryJsonConverter;
import com.amirshiati.androidwoocommercesdk.helper.ProductJsonConverter;
import com.amirshiati.androidwoocommercesdk.helper.Utils;
import com.amirshiati.androidwoocommercesdk.helper.Volley;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetCategoriesFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetCategoryFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonArrayFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonObjectFinished;
import com.amirshiati.androidwoocommercesdk.model.Category;
import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CategoryManager {

    private Uri.Builder builder;
    private CategoryManagerType type;
    private Volley volley;

    private OnGetCategoriesFinished onGetCategoriesFinished;
    private OnGetCategoryFinished onGetCategoryFinished;
    private int page = 1;
    private int perPage = 10;
    private String search;
    private Order order;
    private OrderBy orderBy;
    private Boolean hideEmpty;
    private Long parent;
    private Long product;
    private String slug;
    private int[] include;
    private int[] exclude;

    public CategoryManager(Uri.Builder builder, CategoryManagerType type, Volley volley) {
        this.builder = builder;
        this.type = type;
        this.volley = volley;
    }

    public CategoryManager addGetCategoriesCallBack(OnGetCategoriesFinished onGetCategoriesFinished) {
        this.onGetCategoriesFinished = onGetCategoriesFinished;
        return this;
    }

    public CategoryManager addGetCategoryCallBack(OnGetCategoryFinished onGetCategoryFinished) {
        this.onGetCategoryFinished = onGetCategoryFinished;
        return this;
    }

    public CategoryManager setPage(int page) {
        this.page = page;
        return this;
    }

    public CategoryManager setPerPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public CategoryManager search(String search) {
        this.search = search;
        return this;
    }

    public CategoryManager setOrder(Order order) {
        this.order = order;
        return this;
    }

    public CategoryManager setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public CategoryManager hideEmpty(boolean hideEmpty) {
        this.hideEmpty = hideEmpty;
        return this;
    }

    public CategoryManager setParent(long parent) {
        this.parent = parent;
        return this;
    }

    public CategoryManager setProduct(long product) {
        this.product = product;
        return this;
    }

    public CategoryManager slug(String slug) {
        this.slug = slug;
        return this;
    }

    public CategoryManager setInclude(int[] include) {
        this.include = include;
        return this;
    }

    public CategoryManager setExclude(int[] exclude) {
        this.exclude = exclude;
        return this;
    }

    public void start() {
        switch (type) {
            case GETCATEGORIES:
                getCategories(this, setBuilder(this));
                break;

            case GETCATEGORY:
                setBuilder(this);
                getCategory(this);

            default:
                return;
        }
    }

    private String setBuilder(final CategoryManager categoryManager) {
        if (categoryManager.type == CategoryManagerType.GETCATEGORY)
            return categoryManager.builder.build().toString();

        String array = "";

        categoryManager.builder.appendQueryParameter("page", String.valueOf(categoryManager.page));
        categoryManager.builder.appendQueryParameter("per_page", String.valueOf(categoryManager.perPage));

        if (!Utils.stringEmpty(categoryManager.search))
            categoryManager.builder.appendQueryParameter("search", categoryManager.search);

        if (categoryManager.order != null)
            categoryManager.builder.appendQueryParameter("order", Utils.setBuilderOrder(categoryManager.order));

        if (categoryManager.orderBy != null)
            categoryManager.builder.appendQueryParameter("orderby", Utils.setBuilderOrderBy(categoryManager.orderBy));

        if (categoryManager.hideEmpty != null)
            categoryManager.builder.appendQueryParameter("hide_empty", String.valueOf(categoryManager.hideEmpty));

        if (categoryManager.parent != null)
            categoryManager.builder.appendQueryParameter("parent", String.valueOf(categoryManager.parent));

        if (categoryManager.product != null)
            categoryManager.builder.appendQueryParameter("product", String.valueOf(categoryManager.product));

        if (!Utils.stringEmpty(categoryManager.slug))
            categoryManager.builder.appendQueryParameter("slug", categoryManager.slug);

        if (categoryManager.include != null)
            array += Utils.includeId(categoryManager.include, "include");

        if (categoryManager.exclude != null)
            array += Utils.includeId(categoryManager.exclude, "exclude");


        return categoryManager.builder.build().toString() + array;

    }


    private void getCategories(final CategoryManager categoryManager, String url) {
        final ArrayList<Category> result = new ArrayList<Category>();

        volley.basicAuthJsonArrayReq(
                Request.Method.GET,
                url,
                null,
                new OnGetJsonArrayFinished() {
                    @Override
                    public void onSuccess(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++)
                                result.add(CategoryJsonConverter.jsonToCategory(response.getJSONObject(i)));

                            if (categoryManager.onGetCategoriesFinished != null)
                                categoryManager.onGetCategoriesFinished.onSuccess(result);

                        } catch (Exception e) {
                            if (categoryManager.onGetCategoriesFinished != null)
                                categoryManager.onGetCategoriesFinished.onFail(" Error: " + e.getMessage());
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

                        if (categoryManager.onGetCategoriesFinished != null)
                            categoryManager.onGetCategoriesFinished.onFail(body);
                    }
                });
    }

    private void getCategory(final CategoryManager categoryManager) {
        volley.basicAuthJsonObjReq(
                Request.Method.GET,
                builder.build().toString(),
                null,
                new OnGetJsonObjectFinished() {
                    @Override
                    public void onSuccess(JSONObject response) {
                        try {
                            if (categoryManager.onGetCategoryFinished != null)
                                categoryManager.onGetCategoryFinished.onSuccess(CategoryJsonConverter.jsonToCategory(response));

                        } catch (Exception e) {
                            if (categoryManager.onGetCategoryFinished != null)
                                categoryManager.onGetCategoryFinished.onFail(" Error: " + e.getMessage());
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

                        if (categoryManager.onGetCategoryFinished != null)
                            categoryManager.onGetCategoryFinished.onFail(body);
                    }
                });
    }
}
