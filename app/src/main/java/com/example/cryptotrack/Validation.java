package com.example.cryptotrack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final String CREDENTIALS_PATTERN = "^[a-zA-Z@._*/]{8,20}$";

    public static boolean isCredentialsValid(String credentials) {
        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);
        Matcher matcher = pattern.matcher(credentials);
        return matcher.matches();
    }
}
