package com.example.mvvmsample.viewModels;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmsample.data.AppDataManager;
import com.example.mvvmsample.data.api.AppApiHelper;
import com.example.mvvmsample.data.models.UserResponse;
import com.example.mvvmsample.data.prefs.AppPreferencesHelper;
import com.example.mvvmsample.retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;

//Use the AndroidViewModel to get the application reference
public class MainViewModel extends AndroidViewModel {

    private static final String TAG = "MainViewModel";

    //Data Source
    AppDataManager appDataManager;
    private Context context;


    //Mutable LiveData for storing the list of user
    private MutableLiveData<UserResponse> userList;


    //Getter method for the user list
    public LiveData<UserResponse> getUserList(){
        if (userList==null)
            userList = new MutableLiveData<>();
        return userList;
    }




    public MainViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
        this.appDataManager = AppDataManager.getInstance(context);
        Log.d(TAG, "MainViewModel: " +(this.appDataManager == null));

    }

    //Method to get user from the api call.
    //Retrofit and Rxjava is used for the network call.

    public void getUsers(){
        
        appDataManager.getUserList().subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<UserResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        Log.d(TAG, "onSubscribe: ");

                    }

                    @Override
                    public void onNext(Response<UserResponse> userResponseResponse) {
                        Log.d(TAG, "onNext: " + userResponseResponse.toString());

                        userList.setValue(userResponseResponse.body());
                      //  userList.setValue(userResponseResponse.body().getUsers());
                      //  Log.d(TAG, "onNext: " + userResponseResponse.body().getUsers().size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ",e );
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete:");
                    }
                });
        
        
    }

    //Saving to shared Prefs
    public void saveDataToSharedPrefs(String name){
        appDataManager.setUserName(name);
    }

    //Getter method from shared Prefs
    public String getDataFromSharedPrefs(){
        return appDataManager.getUserName();
    }


}
