package com.example.mvvmsample.data.api;

import com.example.mvvmsample.data.models.UserResponse;

import io.reactivex.Observable;
import retrofit2.Response;

//Helper interface for api
public interface ApiHelper {

    Observable<Response<UserResponse>> getUserList();

}
