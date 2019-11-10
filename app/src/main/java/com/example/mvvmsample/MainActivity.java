package com.example.mvvmsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvmsample.R;
import com.example.mvvmsample.retrofit.RetrofitClient;
import com.example.mvvmsample.viewModels.MainViewModel;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    
    
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        if (viewModel==null)
            Log.d(TAG, "onCreate: VIEWMODEL IS NULL" );
        else
            Log.d(TAG, "onCreate: VIEWMODEL IS NOT NULL");



        viewModel.getUsers();


    }

}
