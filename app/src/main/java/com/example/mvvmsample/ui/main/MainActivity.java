package com.example.mvvmsample.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmsample.R;
import com.example.mvvmsample.data.models.UserResponse;
import com.example.mvvmsample.ui.main.adapter.RecyclerViewAdapter;
import com.example.mvvmsample.viewModels.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    MainViewModel viewModel;

    //Butterknife injection
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    List<String>  mUserList;
    private RecyclerViewAdapter recyclerViewAdapter;


    private void initAdapter(Context context){
        recyclerViewAdapter = new RecyclerViewAdapter(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ButterKnife injection is made here
        ButterKnife.bind(this);


        mUserList= new ArrayList<>();

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        if (viewModel == null)
            Log.d(TAG, "onCreate: VIEWMODEL IS NULL");
        else
            Log.d(TAG, "onCreate: VIEWMODEL IS NOT NULL");

        initAdapter(this);
        setRecyclerAdapter(this,recyclerView,recyclerViewAdapter);



        viewModel.getUsers();
        subscribeObserver();

//        saving data to shared prefs
        viewModel.saveDataToSharedPrefs("Your Name");

//        check data from shared prefs
        Log.d(TAG, "onCreate: "+viewModel.getDataFromSharedPrefs());

    }

    //Subscribing to the observer of the dataSource
    private void subscribeObserver(){
        viewModel.getUserList().observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                Log.d(TAG, "onChanged: " + userResponse.getUsers());
                mUserList = userResponse.getUsers();

                recyclerViewAdapter.updateList(mUserList);

            }
        });
    }

    //Setting up the adpter
    private void setRecyclerAdapter(Context context,RecyclerView recyclerView,RecyclerView.Adapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}
