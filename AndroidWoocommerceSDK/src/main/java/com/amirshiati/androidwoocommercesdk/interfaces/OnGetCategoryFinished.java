package com.amirshiati.androidwoocommercesdk.interfaces;

import com.amirshiati.androidwoocommercesdk.model.Category;

public interface OnGetCategoryFinished {

    void onSuccess(Category category);

    void onFail(String message);

}
