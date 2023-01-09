package com.example.demoserviceapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApiEndpointInterface {
    /*@GET("posts/")
    Call<UserModel> getUser(@Path("posts/") String username);

    @GET("posts/")
    Call<List<UserModel>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @POST("posts/")
    Call<UserModel> createUser(@Body UserModel user);*/

    @GET("posts/")
    Call<List<UserModel>> getUser();
}
