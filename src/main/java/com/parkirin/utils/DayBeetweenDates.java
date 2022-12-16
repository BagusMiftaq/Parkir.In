package com.parkirin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DayBeetweenDates {
    public static Integer differentDay(Date firstDate, Date secondDate){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date firstDate = sdf.parse("2017-06-24");
//        Date secondDate = sdf.parse("2017-06-30");

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return Integer.valueOf(String.valueOf(diff));
    }

    public static Integer extractMonth(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = sdf.parse(date.toString());
        Integer month = firstDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().getMonthValue();

        return month;
    }
}
