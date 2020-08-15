package com.psj.shareapp.utils;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

public class Data{

    private final int NOT_FOUND=4040;
    private final String KEY="User.name0";

    public static String SDBNAME="com.psj.shareapp";
    private SharedPreferences mSharedPrefs;

    public Data(SharedPreferences mSharedPrefs) { this.mSharedPrefs=mSharedPrefs; }

    public String getUserName() { return mSharedPrefs.getString(KEY,"404:NoSuchUser"+NOT_FOUND); }

    public void setUserName(@NonNull String userName)
    {
        SharedPreferences.Editor editor=mSharedPrefs.edit();
        editor.clear();
        editor.putString(KEY,userName);
        editor.apply();
    }
}
