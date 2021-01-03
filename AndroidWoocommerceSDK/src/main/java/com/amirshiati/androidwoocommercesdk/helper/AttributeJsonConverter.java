package com.amirshiati.androidwoocommercesdk.helper;

import com.amirshiati.androidwoocommercesdk.enums.AttributeOrderBy;
import com.amirshiati.androidwoocommercesdk.model.Attribute;

import org.json.JSONException;
import org.json.JSONObject;

import static com.amirshiati.androidwoocommercesdk.helper.ProductJsonConverter.getLong;
import static com.amirshiati.androidwoocommercesdk.helper.ProductJsonConverter.getString;

public class AttributeJsonConverter {
    public static Attribute jsonToAttribute(JSONObject toConvert) throws JSONException {
        return new Attribute(
                getLong(toConvert, "id"),
                getString(toConvert, "name"),
                getString(toConvert, "slug"),
                jsonToAttributeOrderBy(toConvert),
                toConvert.getBoolean("has_archives")
        );
    }

    public static AttributeOrderBy jsonToAttributeOrderBy(JSONObject toGet) throws JSONException {
        switch (getString(toGet, "order_by")) {
            case "name":
                return AttributeOrderBy.NAME;

            case "name_num":
                return AttributeOrderBy.NAME_NUM;

            case "id":
                return AttributeOrderBy.ID;

            default:
                return AttributeOrderBy.MENU_ORDER;
        }
    }
}
