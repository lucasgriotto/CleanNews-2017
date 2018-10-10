package com.cleannews.cleannews.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by lucas on 10/24/17.
 */

public final class Utils {

    public static String dateToStringDateFormat(Date date) {
        TimeZone tx = TimeZone.getDefault();
        DateFormat formatter = new SimpleDateFormat("E dd/MM/yyyy - kk:mm");
        formatter.setTimeZone(tx);
        String formattedDate = formatter.format(date);
        return formattedDate;
    }
}
