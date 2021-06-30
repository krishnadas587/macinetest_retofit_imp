package com.example.machinetest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_implementation {
    static String Base_url="https://reqres.in/api/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

retro_apis apis=retrofit.create(retro_apis.class);
}
