package com.amirshiati.androidwoocommercesdk.helper;

import android.net.Uri;

import com.amirshiati.androidwoocommercesdk.enums.Order;
import com.amirshiati.androidwoocommercesdk.enums.OrderBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public static String setBuilderOrder(Order order) {
        switch (order) {
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

    public static String includeId(int[] ids, String key) {
        String url = "";
        int i = 0;

        for (int j = 0; j < ids.length; j++)
            url += ("&" + key + "[" + (i++) + "]" + "=" + (ids[j]) + "");

        return url;
    }
}
