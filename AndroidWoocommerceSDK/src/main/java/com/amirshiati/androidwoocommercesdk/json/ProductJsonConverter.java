package com.amirshiati.androidwoocommercesdk.json;

import com.amirshiati.androidwoocommercesdk.enums.ProductBackOrdered;
import com.amirshiati.androidwoocommercesdk.enums.ProductCatalogVisibility;
import com.amirshiati.androidwoocommercesdk.enums.ProductStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductStockStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductType;
import com.amirshiati.androidwoocommercesdk.enums.TaxStatus;
import com.amirshiati.androidwoocommercesdk.helper.Utils;
import com.amirshiati.androidwoocommercesdk.model.ProductAttribute;
import com.amirshiati.androidwoocommercesdk.model.Category;
import com.amirshiati.androidwoocommercesdk.model.DefaultAttribute;
import com.amirshiati.androidwoocommercesdk.model.Image;
import com.amirshiati.androidwoocommercesdk.model.Product;
import com.amirshiati.androidwoocommercesdk.model.ProductDimensions;
import com.amirshiati.androidwoocommercesdk.model.ProductDownloadProperties;
import com.amirshiati.androidwoocommercesdk.model.Tag;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductJsonConverter {

    public static Product jsonToProduct(JSONObject toConvert) {
        try {
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
                    getString(toConvert, "purchase_note"),
                    //get categories
                    getCategories(toConvert),
                    //get tags
                    getTags(toConvert),
                    //get images
                    getImages(toConvert),
                    //get attributes
                    getAttributes(toConvert),
                    //get default attributes
                    getDefaultAttributes(toConvert),
                    //get variations
                    getLongArray(toConvert, "variations"),
                    //get grouped products
                    getLongArray(toConvert, "grouped_products"),
                    // get menu order
                    getLong(toConvert, "menu_order")
            );
        } catch (Exception e) {
            return new Product(-1L);
        }
    }


    public static ArrayList<DefaultAttribute> getDefaultAttributes(JSONObject toGet) throws JSONException {
        if (!toGet.has("default_attributes"))
            return null;

        ArrayList<DefaultAttribute> result = new ArrayList<>();

        JSONArray jsonArray = toGet.getJSONArray("default_attributes");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            result.add(jsonToDefaultAttribute(object));
        }

        return result;
    }

    public static DefaultAttribute jsonToDefaultAttribute(JSONObject toGet) throws JSONException {
        return new DefaultAttribute(
                getLong(toGet, "id"),
                getString(toGet, "name"),
                getString(toGet, "option")
        );
    }

    public static ArrayList<ProductAttribute> getAttributes(JSONObject toGet) throws JSONException {
        if (!toGet.has("attributes"))
            return null;

        ArrayList<ProductAttribute> result = new ArrayList<>();

        JSONArray jsonArray = toGet.getJSONArray("attributes");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            result.add(jsonToAttribute(object));
        }

        return result;
    }

    public static ProductAttribute jsonToAttribute(JSONObject toGet) throws JSONException {
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < toGet.getJSONArray("options").length(); i++)
            options.add(toGet.getJSONArray("options").getString(i));

        return new ProductAttribute(
                getLong(toGet, "id"),
                getString(toGet, "name"),
                getLong(toGet, "position"),
                toGet.getBoolean("visible"),
                toGet.getBoolean("variation"),
                options
        );
    }

    public static ArrayList<Category> getCategories(JSONObject toGet) throws JSONException {
        if (!toGet.has("categories"))
            return null;

        ArrayList<Category> result = new ArrayList<>();

        JSONArray jsonArray = toGet.getJSONArray("categories");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            result.add(jsonToCategory(object));
        }

        return result;
    }

    public static ArrayList<Image> getImages(JSONObject toGet) throws JSONException {
        if (!toGet.has("images"))
            return null;

        ArrayList<Image> result = new ArrayList<>();

        JSONArray jsonArray = toGet.getJSONArray("images");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            result.add(jsonToImage(object));
        }

        return result;
    }

    public static ArrayList<Tag> getTags(JSONObject toGet) throws JSONException {
        if (!toGet.has("tags"))
            return null;

        ArrayList<Tag> result = new ArrayList<>();

        JSONArray jsonArray = toGet.getJSONArray("tags");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            result.add(jsonToTag(object));
        }

        return result;
    }

    public static Category jsonToCategory(JSONObject toGet) throws JSONException {
        return new Category(
                getLong(toGet, "id"),
                getString(toGet, "name"),
                getString(toGet, "slug")
        );
    }

    public static Tag jsonToTag(JSONObject toGet) throws JSONException {
        return new Tag(
                getLong(toGet, "id"),
                getString(toGet, "name"),
                getString(toGet, "slug")
        );
    }


    public static Image jsonToImage(JSONObject toGet) throws JSONException {
        return new Image(
                getLong(toGet, "id"),
                Utils.stringToDate(getString(toGet, "date_created")),
                Utils.stringToDate(getString(toGet, "date_modified")),
                getString(toGet, "src"),
                getString(toGet, "name"),
                getString(toGet, "alt")
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
