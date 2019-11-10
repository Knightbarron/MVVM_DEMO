package com.example.mvvmsample.data;

import android.content.Context;

import com.example.mvvmsample.data.api.AppApiHelper;
import com.example.mvvmsample.data.models.UserResponse;
import com.example.mvvmsample.data.prefs.AppPreferencesHelper;

import io.reactivex.Observable;
import retrofit2.Response;

public class AppDataManager implements DataManagerHelper {

    private AppApiHelper apiHelper;
    private AppPreferencesHelper preferencesHelper;

    private Context context;
    private static final String TAG = "AppDataManager";

    private static AppDataManager instance;

    public AppDataManager(Context context) {
        this.context = context;

        apiHelper = AppApiHelper.getInstance(context);
        preferencesHelper = AppPreferencesHelper.getInstance(context);

    }

    //DOuble check synchronised block to create an instance
    public static  AppDataManager  getInstance(Context context) {

        if (instance == null){
            synchronized(AppDataManager.class){
                    if(instance == null){
                        instance = new AppDataManager(context);
                    }
            }
        }

        return instance;
    }

    @Override
    public String getUserName() {
        return preferencesHelper.getUserName();
    }

    @Override
    public void setUserName(String username) {
        preferencesHelper.setUserName(username);
    }

    @Override
    public Observable<Response<UserResponse>> getUserList() {
        return apiHelper.getUserList();
    }
}
