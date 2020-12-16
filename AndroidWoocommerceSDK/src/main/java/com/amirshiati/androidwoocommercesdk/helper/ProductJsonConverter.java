package com.amirshiati.androidwoocommercesdk.helper;

import com.amirshiati.androidwoocommercesdk.enums.ProductBackOrdered;
import com.amirshiati.androidwoocommercesdk.enums.ProductCatalogVisibility;
import com.amirshiati.androidwoocommercesdk.enums.ProductStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductStockStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductType;
import com.amirshiati.androidwoocommercesdk.enums.TaxStatus;
import com.amirshiati.androidwoocommercesdk.model.Product;
import com.amirshiati.androidwoocommercesdk.model.ProductDimensions;
import com.amirshiati.androidwoocommercesdk.model.ProductDownloadProperties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductJsonConverter {

    public static Product jsonToProduct(JSONObject toConvert) throws JSONException {
        return new Product(getLong(toConvert, "id"),
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
                getLong(toConvert, "total_sales"),
                toConvert.getBoolean("virtual"),
                toConvert.getBoolean("downloadable"),
                //get downloads object
                getDownloadProperties(toConvert),
                //--
                getLong(toConvert, "download_limit"),
                getLong(toConvert, "download_expiry"),
                getString(toConvert, "external_url"),
                getString(toConvert, "button_text"),
                getProductTaxStatus(toConvert),
                getString(toConvert, "tax_class"),
                toConvert.getBoolean("manage_stock"),
                getLong(toConvert, "stock_quantity"),
                //get stock status
                getProductStockStatus(toConvert),
                //get back ordered
                getProductBackOrdered(toConvert),
                //--
                toConvert.getBoolean("backorders_allowed"),
                toConvert.getBoolean("backordered"),
                toConvert.getBoolean("sold_individually"),
                getString(toConvert, "weight"),
                //get dimensions
                getProductDimensions(toConvert),
                //--
                toConvert.getBoolean("shipping_required"),
                toConvert.getBoolean("shipping_taxable"),
                getString(toConvert, "shipping_class"),
                getLong(toConvert, "shipping_class_id"),
                toConvert.getBoolean("reviews_allowed"),
                getString(toConvert, "average_rating"),
                getLong(toConvert, "rating_count"),
                //get related ids
                getLongArray(toConvert, "related_ids"),
                getLongArray(toConvert, "upsell_ids"),
                getLongArray(toConvert, "cross_sell_ids"),
                //--
                getLong(toConvert, "parent_id"),
                getString(toConvert, "purchase_note")
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

    public static ArrayList<ProductDownloadProperties> getDownloadProperties(JSONObject toGet) throws JSONException {
        ArrayList<ProductDownloadProperties> result = new ArrayList<>();
        for (int i = 0; i < toGet.getJSONArray("downloads").length(); i++) {
            JSONObject object = toGet.getJSONArray("downloads").getJSONObject(i);
            result.add(new ProductDownloadProperties(
                    getString(toGet, "id"),
                    getString(object, "name"),
                    getString(object, "file"))
            );
        }

        return result;
    }

    public static TaxStatus getProductTaxStatus(JSONObject toGet) throws JSONException {
        switch (getString(toGet, "tax_status")) {
            case "taxable":
                return TaxStatus.TAXABLE;

            case "shipping":
                return TaxStatus.SHIPPING;

            case "none":
                return TaxStatus.NONE;

            default:
                return null;
        }
    }

    public static ProductStockStatus getProductStockStatus(JSONObject toGet) throws JSONException {
        switch (getString(toGet, "stock_status")) {
            case "instock":
                return ProductStockStatus.INSTOCK;

            case "outofstock":
                return ProductStockStatus.OUTOFSTOCK;

            case "onbackorder":
                return ProductStockStatus.ONBACKORDER;

            default:
                return null;
        }
    }

    public static ProductBackOrdered getProductBackOrdered(JSONObject toGet) throws JSONException {
        switch (getString(toGet, "backorders")) {
            case "no":
                return ProductBackOrdered.NO;

            case "notify":
                return ProductBackOrdered.NOTIFY;

            case "yes":
                return ProductBackOrdered.YES;

            default:
                return null;
        }
    }

    public static ProductDimensions getProductDimensions(JSONObject toGet) throws JSONException {
        JSONObject object = toGet.getJSONObject("dimensions");
        return new ProductDimensions(
                getString(object, "length"),
                getString(object, "width"),
                getString(object, "height")
        );
    }

    public static ArrayList<Long> getLongArray(JSONObject toGet, String key) throws JSONException {
        JSONArray array = toGet.getJSONArray(key);

        ArrayList<Long> result = new ArrayList<>();
        for (int i = 0; i < array.length(); i++)
            result.add(array.getLong(i));

        return result;
    }

    public static String getString(JSONObject toGet, String key) throws JSONException {
        if (!toGet.isNull(key))
            return toGet.getString(key);

        return "";
    }

    public static long getLong(JSONObject toGet, String key) throws JSONException {
        if (!toGet.isNull(key))
            return toGet.getLong(key);

        return -1;
    }
}
