package com.example.cryptotrack;

//import android.content.Context;
//import android.content.SharedPreferences;
//
//public class User {
//    private String username;
//    private String password;
//    private String email;
//
//    private SharedPreferences sharedPreferences;
//    private static final String PREFERENCES_PACKAGE_NAME = "com.example.crypto";
//    private static final String USERNAME_KEY = "username";
//    private static final String PASSWORD_KEY = "password";
//    private static final String REMEMBERME_KEY = "rememberMeCheckBox";
//
//    public User(String username, String password, String email){
//        this.username = username;
//        this.password = password;
//        this.email = email;
//    }
//    public User (Context context) {
//        this.sharedPreferences = context.getSharedPreferences(User.PREFERENCES_PACKAGE_NAME,
//                Context.MODE_PRIVATE);
//    }
//    public String getUsernameForRegistration() {
//        return username;
//    }
//
//    public String getPasswordForRegistration() {
//        return password;
//    }
//
//    public String getEmailForRegistration() {
//        return email;
//    }
//
//    //----------------------------------
//    public void setUsernameForRegistration(String username) {
//        this.username = username;
//    }
//
//    public void setPasswordForRegistration(String password) {
//        this.password = password;
//    }
//
//    public void setEmailForRegistration(String email) {
//        this.email = email;
//    }
//
//    //-----------------------------------
//
//    public String getUsernameForLogin() {
//        return this.sharedPreferences.edit().getString(USERNAME_KEY, "");
//    }
//}
