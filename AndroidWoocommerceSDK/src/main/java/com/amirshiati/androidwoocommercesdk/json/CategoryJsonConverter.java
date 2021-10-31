package com.amirshiati.androidwoocommercesdk.helper;



import com.amirshiati.androidwoocommercesdk.enums.CategoryDisplay;
import com.amirshiati.androidwoocommercesdk.model.Category;
import com.amirshiati.androidwoocommercesdk.model.Image;

import org.json.JSONException;
import org.json.JSONObject;

import static com.amirshiati.androidwoocommercesdk.helper.ProductJsonConverter.getLong;
import static com.amirshiati.androidwoocommercesdk.helper.ProductJsonConverter.getString;

public class CategoryJsonConverter {
    public static Category jsonToCategory(JSONObject toConvert) throws JSONException {
        return new Category(
                getLong(toConvert, "id"),
                getString(toConvert, "name"),
                getString(toConvert, "slug"),
                getLong(toConvert, "parent"),
                getString(toConvert, "description"),
                jsonToCategoryDisplay(toConvert),
                jsonToImage(toConvert),
                getLong(toConvert, "menu_order"),
                getLong(toConvert, "count")
        );
    }

    public static Image jsonToImage(JSONObject toGet) throws JSONException {
        if (toGet.isNull("image"))
            return null;

        JSONObject object = toGet.getJSONObject("image");
        return new Image(
                getLong(object, "id"),
                Utils.stringToDate(getString(object, "date_created")),
                Utils.stringToDate(getString(object, "date_modified")),
                getString(object, "src"),
                getString(object, "name"),
                getString(object, "alt")
        );
    }

    public static CategoryDisplay jsonToCategoryDisplay(JSONObject toGet) throws JSONException {
        switch (getString(toGet, "display")) {
            case "products":
                return CategoryDisplay.PRODUCTS;

            case "subcategories":
                return CategoryDisplay.SUBCATEGORIES;

            case "both":
                return CategoryDisplay.BOTH;

            default:
                return CategoryDisplay.DEFAULT;
        }
    }
}
