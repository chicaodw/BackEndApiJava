package com.provateTecnica.Api.util;

import com.provateTecnica.Api.model.UserModel;

public class TextSearchUtil {
    public static String textSearch(String text, String keyword) {
        if (text != null && keyword != null && !keyword.isEmpty()) {
            String textHighLight = text.replace("(?i)" + keyword, "<strong>$0</strong>");

            return textHighLight;
        }
        return text;
    }

    public static boolean filteredUserContainsKeyword(UserModel user) {
        return user.getName() != null || user.getLast_name() != null ||
                user.getCity() != null || user.getState() != null ||
                user.getCountry() != null || user.getEmail() != null;
    }
}
