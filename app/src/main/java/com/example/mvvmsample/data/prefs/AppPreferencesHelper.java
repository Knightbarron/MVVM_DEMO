package com.example.mvvmsample.data.prefs;

import android.content.SharedPreferences;

public class AppPreferencesHelper  implements PreferencesHelper{

    private SharedPreferences mPrefs;
    public static final String PREF_KEY_USERNAME = "pref_key_username";

    @Override
    public String getUserName() {
        return mPrefs.getString(PREF_KEY_USERNAME,"");
    }

    @Override
    public void setUserName(String username) {
        mPrefs.edit().putString(PREF_KEY_USERNAME,username).apply();
    }
}
