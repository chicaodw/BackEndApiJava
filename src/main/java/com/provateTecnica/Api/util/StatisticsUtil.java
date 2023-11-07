package com.provateTecnica.Api.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class StatisticsUtil {
    private static String dateFormat = "dd/MM/yyyy";

    public static int calculateAge(String birthday) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate birthDate = LocalDate.parse(birthday, formatter);
        LocalDate currentDate = LocalDate.now();

        int age = Period.between(birthDate, currentDate).getYears();

        if (currentDate.getMonthValue() < birthDate.getMonthValue() ||
                (currentDate.getMonthValue() == birthDate.getMonthValue() &&
                        currentDate.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }

        return age;
    }

    public static String determineAgeRange(int age) {
        if (age >= 21 && age <= 30) {
            return "21_30";
        } else if (age >= 31 && age <= 40) {
            return "31_40";
        } else if (age >= 41 && age <= 60) {
            return "41_60";
        } else if (age >= 61 & age <= 80) {
            return "61_80";
        } else {
            return "other";
        }
    }
}
