package com.itau.api.offers.utils;

import java.util.Calendar;
import java.util.Date;

public class OffersUtils {
    public static String getDateDays(int days) {
        Calendar calendar= Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        Date date = calendar.getTime();
        return date.toString();
    }
}
