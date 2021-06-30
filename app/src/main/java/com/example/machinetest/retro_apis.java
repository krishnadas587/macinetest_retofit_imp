package com.example.machinetest;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface retro_apis {
    @GET("users")
    Call<model_first> getuser();
}
