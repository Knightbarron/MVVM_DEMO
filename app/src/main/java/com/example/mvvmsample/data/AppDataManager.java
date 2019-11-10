package com.example.mvvmsample.data;

import android.content.Context;
import android.util.Log;

import com.example.mvvmsample.data.api.AppApiHelper;
import com.example.mvvmsample.data.models.UserResponse;
import com.example.mvvmsample.data.prefs.AppPreferencesHelper;
import com.example.mvvmsample.retrofit.RetrofitClient;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AppDataManager implements DataManager{

   private  AppApiHelper apiHelper;
   private  AppPreferencesHelper preferencesHelper;

   private Context context;
    private static final String TAG = "AppDataManager";

   private static AppDataManager instance;

    public AppDataManager(Context context) {
        this.context = context;

        apiHelper = AppApiHelper.getInstance(context);


        if (apiHelper==null)
            Log.d(TAG, "AppDataManager: ApiHelperis null");
        else Log.d(TAG, "AppDataManager: NOT NULL APIHELPER");
         //TODO add sharedPREFERENCE

    }

    public static AppDataManager getInstance(Context context){

        if (instance==null)
            instance = new AppDataManager(context);
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
