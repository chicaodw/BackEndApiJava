package com.provateTecnica.Api.util;

public class CellFormatUtil {
    public static String formatCell(String cell) {
        String clean = cell.replaceAll("[^\\d]", "");

        String code = clean.substring(0, 3);
        String first = clean.substring(3, 6);
        String second = clean.substring(6);

        return String.format("(%s) %s-%s", code, first, second);
    }
}
