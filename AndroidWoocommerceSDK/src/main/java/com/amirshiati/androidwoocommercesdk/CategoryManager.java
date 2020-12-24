package com.amirshiati.androidwoocommercesdk;

import android.net.Uri;

import com.amirshiati.androidwoocommercesdk.enums.CategoryManagerType;
import com.amirshiati.androidwoocommercesdk.enums.ProductManagerType;
import com.amirshiati.androidwoocommercesdk.helper.CategoryJsonConverter;
import com.amirshiati.androidwoocommercesdk.helper.Utils;
import com.amirshiati.androidwoocommercesdk.helper.Volley;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetCategoriesFinished;
import com.amirshiati.androidwoocommercesdk.interfaces.OnGetJsonArrayFinished;
import com.amirshiati.androidwoocommercesdk.model.Category;
import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CategoryManager {

    private Uri.Builder builder;
    private CategoryManagerType type;
    private Volley volley;

    private OnGetCategoriesFinished onGetCategoriesFinished;

    private int page = 1;
    private int perPage = 10;

    public CategoryManager(Uri.Builder builder, CategoryManagerType type, Volley volley) {
        this.builder = builder;
        this.type = type;
        this.volley = volley;
    }

    public CategoryManager addGetCategoriesCallBack(OnGetCategoriesFinished onGetCategoriesFinished) {
        this.onGetCategoriesFinished = onGetCategoriesFinished;
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


    public void start() {
        switch (type) {
            case GETCATEGORIES:
                getCategories(this, setBuilder(this));
                break;

            default:
                return;
        }
    }

    private String setBuilder(final CategoryManager categoryManager) {
//        if (categoryManager.type == ProductManagerType.GETPRODUCT)
//            return categoryManager.builder.build().toString();

        String array = "";

        categoryManager.builder.appendQueryParameter("page", String.valueOf(categoryManager.page));
        categoryManager.builder.appendQueryParameter("per_page", String.valueOf(categoryManager.perPage));

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
}
