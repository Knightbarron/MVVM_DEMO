package com.example.mvvmsample.data.api;

import android.content.Context;
import android.util.Log;

import com.example.mvvmsample.data.models.UserResponse;
import com.example.mvvmsample.retrofit.RetrofitClient;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

//Api Provider to Data Manager class
public class AppApiHelper implements ApiHelper{

    private static AppApiHelper appApiHelper;

    private ApiService apiService;
    private Context context;

    private Retrofit retrofitClient;


    private static final String TAG = "AppApiHelper";

    //retrofit is instantiated here
    public AppApiHelper(Context context) {
        this.context = context;
        retrofitClient = RetrofitClient.getRetrofit();

        apiService = retrofitClient.create(ApiService.class);
    }


    @Override
    public Observable<Response<UserResponse>> getUserList() {
        return apiService.getUserList();
    }


    //DOuble check synchronised block to create an instance
    public static AppApiHelper getInstance(Context context) {
        if (appApiHelper==null){

            synchronized (AppApiHelper.class){
                if (appApiHelper==null)
                    appApiHelper = new AppApiHelper(context);
            }

        }
        return appApiHelper;
    }



}
