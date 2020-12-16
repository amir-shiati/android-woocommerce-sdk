package com.amirshiati.androidwoocommercesdk.helper;

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
}
