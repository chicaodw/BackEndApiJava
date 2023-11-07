package com.provateTecnica.Api.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DataUlti {
    private static String dateFormat = "dd/MM/yyyy";

    public static String formatDateString(String date) {
        Instant instant = Instant.parse(date);
        LocalDateTime dateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return dateTime.format(formatter);
    }
}
