package com.amirshiati.androidwoocommercesdk.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date stringToDate(String date) {
        Date result = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            result = format.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
}
