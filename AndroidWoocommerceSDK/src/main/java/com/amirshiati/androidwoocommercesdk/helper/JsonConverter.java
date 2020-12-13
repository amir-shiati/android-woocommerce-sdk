package com.amirshiati.androidwoocommercesdk.helper;

import com.amirshiati.androidwoocommercesdk.enums.ProductCatalogVisibility;
import com.amirshiati.androidwoocommercesdk.enums.ProductStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductType;
import com.amirshiati.androidwoocommercesdk.model.Product;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonConverter {

    public static Product jsonToProduct(JSONObject toConvert) throws JSONException {
        return new Product(toConvert.getLong("id"),
                getString(toConvert, "name"),
                getString(toConvert, "slug"),
                getString(toConvert, "permalink"),
                //get dates
                Utils.stringToDate(getString(toConvert, "date_created")),
                Utils.stringToDate(getString(toConvert, "date_modified")),
                //get type
                getProductType(toConvert),
                //get status
                getProductStatus(toConvert),
                //get featured
                toConvert.getBoolean("featured"),
                //get catalog visibility
                getProductCatalogVisibility(toConvert),
                //get strings
                getString(toConvert, "description"),
                getString(toConvert, "short_description"),
                getString(toConvert, "sku"),
                getString(toConvert, "price"),
                getString(toConvert, "regular_price"),
                getString(toConvert, "sale_price"),
                //get sales dates
                Utils.stringToDate(getString(toConvert, "date_on_sale_from")),
                Utils.stringToDate(getString(toConvert, "date_on_sale_to")),
                //--
                getString(toConvert, "price_html"),
                toConvert.getBoolean("on_sale"),
                toConvert.getBoolean("purchasable"),
                toConvert.getLong("total_sales"),
                toConvert.getBoolean("virtual"),
                toConvert.getBoolean("downloadable")
        );
    }


    public static ProductType getProductType(JSONObject toGet) throws JSONException {
        switch (getString(toGet, "type")) {
            case "simple":
                return ProductType.SIMPLE;

            case "grouped":
                return ProductType.GROUPED;

            case "external":
                return ProductType.EXTERNAL;

            case "variable":
                return ProductType.VARIABLE;

            default:
                return null;
        }
    }

    public static ProductStatus getProductStatus(JSONObject toGet) throws JSONException {
        switch (getString(toGet, "status")) {
            case "draft":
                return ProductStatus.DRAFT;

            case "pending":
                return ProductStatus.PENDING;

            case "private":
                return ProductStatus.PRIVATE;

            case "publish":
                return ProductStatus.PUBLISH;

            default:
                return null;
        }
    }

    public static ProductCatalogVisibility getProductCatalogVisibility(JSONObject toGet) throws JSONException {
        switch (getString(toGet, "catalog_visibility")) {
            case "visible":
                return ProductCatalogVisibility.VISIBLE;

            case "catalog":
                return ProductCatalogVisibility.CATALOG;

            case "search":
                return ProductCatalogVisibility.SEARCH;

            case "hidden":
                return ProductCatalogVisibility.HIDDEN;

            default:
                return null;
        }
    }

    public static String getString(JSONObject toGet, String key) throws JSONException {
        if (!toGet.isNull(key))
            return toGet.getString(key);

        return "";
    }
}
