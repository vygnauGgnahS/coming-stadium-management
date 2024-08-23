package com.situ.stadium.util;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    //标准日期时间格式
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //字符串转换为日期时间格式
    public static LocalDateTime parseDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, formatter);
    }

    //计算时长
    public static double duration(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        return (double) duration.toMinutes();
    }

}
