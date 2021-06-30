package com.example.machinetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle_holder);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        setuprecycle();
    }
    void setuprecycle(){
Call<model_first> val=new Retrofit_implementation().apis.getuser();
val.enqueue(new Callback<model_first>() {
    @Override
    public void onResponse(Call<model_first> call, Response<model_first> response) {
      Recycle_adapter adapter=new Recycle_adapter(response.body().getData(),MainActivity.this);
      recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<model_first> call, Throwable t) {
        System.out.println("no "+t.getMessage());
    }
});

    }
}