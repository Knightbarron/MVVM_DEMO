package com.example.mvvmsample.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

//Shared Preferences Class
public class AppPreferencesHelper  implements PreferencesHelper{

    private SharedPreferences mPrefs;
    private static AppPreferencesHelper preferencesHelper;
    public static final String PREF_KEY_USERNAME = "pref_key_username";
    private Context context;

    public AppPreferencesHelper(Context context) {
        this.context = context;

        //initializing the shared Preferences
        mPrefs = context.getSharedPreferences("", Context.MODE_PRIVATE);

    }

    @Override
    public String getUserName() {
        return mPrefs.getString(PREF_KEY_USERNAME,"");
    }

    @Override
    public void setUserName(String username) {
        mPrefs.edit().putString(PREF_KEY_USERNAME,username).apply();
    }

    //Double check synchronised block to create an instance
    public static AppPreferencesHelper getInstance(Context context){

        if (preferencesHelper==null) {
            synchronized (AppPreferencesHelper.class) {
                if (preferencesHelper==null)
                    preferencesHelper = new AppPreferencesHelper(context);
            }
        }
        return preferencesHelper;

    }

}
