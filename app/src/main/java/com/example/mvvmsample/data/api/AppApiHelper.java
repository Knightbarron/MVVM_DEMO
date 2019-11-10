package com.example.mvvmsample.data.api;

import android.content.Context;
import android.util.Log;

import com.example.mvvmsample.data.models.UserResponse;
import com.example.mvvmsample.retrofit.RetrofitClient;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AppApiHelper implements ApiService{

    private static AppApiHelper appApiHelper;
    private ApiService apiService;

    private Context context;

    Retrofit retrofitClient;


    private static final String TAG = "AppApiHelper";
    
    public AppApiHelper(Context context) {
        this.context = context;
     //   appApiHelper = AppApiHelper.getInstance(context);
//        if (retrofitClient==null)
//            Log.d(TAG, "AppApiHelper: Retrofit null");
//        else Log.d(TAG, "AppApiHelper: NOT NULL");
    }

    @Override
    public Observable<Response<UserResponse>> getUserList() {
        return apiService.getUserList();
    }


    public static AppApiHelper getInstance(Context context) {
        if (appApiHelper==null)
            appApiHelper = new AppApiHelper(context);
        return appApiHelper;
    }



}
