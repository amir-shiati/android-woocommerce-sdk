package com.amirshiati.androidwoocommercesdk.interfaces;

import com.amirshiati.androidwoocommercesdk.model.Category;

import java.util.ArrayList;

public interface OnGetCategoriesFinished {

    void onSuccess(ArrayList<Category> categories);

    void onFail(String message);

}
