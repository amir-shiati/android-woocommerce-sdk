package com.amirshiati.androidwoocommercesdk.helper;

import android.util.Log;

import com.amirshiati.androidwoocommercesdk.enums.CategoryOrderBy;
import com.amirshiati.androidwoocommercesdk.enums.OrderSort;
import com.amirshiati.androidwoocommercesdk.enums.OrderBy;
import com.amirshiati.androidwoocommercesdk.enums.OrderStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductStockStatus;
import com.amirshiati.androidwoocommercesdk.enums.ProductType;
import com.android.volley.VolleyError;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date stringToDate(String date) {
        if (stringEmpty(date))
            return null;

        Date result = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            result = format.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean stringEmpty(String str) {
        return str == null || str.equals("") || str.isEmpty() || str.length() <= 0;
    }

    public static String setBuilderOrder(OrderSort orderSort) {
        switch (orderSort) {
            case ASC:
                return "asc";

            default:
                return "desc";
        }
    }

    public static String setBuilderOrderBy(OrderBy orderBy) {
        switch (orderBy) {
            case ID:
                return "id";

            case SLUG:
                return "slug";

            case TITLE:
                return "title";

            case INCLUDE:
                return "include";

            default:
                return "date";
        }
    }

    public static String setBuilderCategoryOrderBy(CategoryOrderBy orderBy) {
        switch (orderBy) {
            case ID:
                return "id";

            case SLUG:
                return "slug";

            case TERM_GROUP:
                return "term_group";

            case COUNT:
                return "count";

            case DESCRIPTION:
                return "description";

            case INCLUDE:
                return "include";

            default:
                return "name";
        }
    }

    public static String setBuilderProductStatus(ProductStatus status) {
        switch (status) {
            case PENDING:
                return "pending";

            case PUBLISH:
                return "publish";

            case PRIVATE:
                return "private";

            case DRAFT:
                return "draft";

            default:
                return "any";
        }
    }

    public static String setBuilderOrderStatus(OrderStatus status) {
        switch (status) {
            case PROCESSING:
                return "processing";

            case ONHOLD:
                return "on-hold";

            case COMPLETED:
                return "completed";

            case CANCELLED:
                return "cancelled";

            case REFUNDED:
                return "refunded";

            case FAILED:
                return "failed";

            case TRASH:
                return "trash";

            case PENDING:
                return "pending";

            default:
                return "any";
        }
    }

    public static String setBuilderProductType(ProductType productType) {
        switch (productType) {
            case EXTERNAL:
                return "external";

            case GROUPED:
                return "grouped";

            case SIMPLE:
                return "simple";

            case VARIABLE:
                return "variable";

            default:
                return "";
        }
    }

    public static String setBuilderProductStockStatus(ProductStockStatus stockStatus) {
        switch (stockStatus) {
            case INSTOCK:
                return "instock";

            case OUTOFSTOCK:
                return "outofstock";

            default:
                return "onbackorder";
        }
    }

    public static String includeId(int[] ids, String key) {
        String url = "";
        int i = 0;

        for (int j = 0; j < ids.length; j++)
            url += ("&" + key + "[" + (i++) + "]" + "=" + (ids[j]) + "");

        return url;
    }

    public static String getVolleyErrorBody(VolleyError error) {
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
        return body;
    }
}
