package com.example.mvvmsample.data.api;

import com.example.mvvmsample.data.models.UserResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

//Network call methods are declared here
public interface ApiService {

    String BASE_URL = "https://5db305d7a394f5001443a97d.mockapi.io/";


    @GET("api/v1/users")
    Observable<Response<UserResponse>> getUserList();

}
