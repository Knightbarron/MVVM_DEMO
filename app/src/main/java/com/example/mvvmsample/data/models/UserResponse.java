package com.example.mvvmsample.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;

public class UserResponse {


    //User Response  class for the data to be retrieved from the api .
    //The serializedName annotation is same as the field name of the data sourece(api).

    @SerializedName("users")
    ArrayList<String> users;

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }
}
