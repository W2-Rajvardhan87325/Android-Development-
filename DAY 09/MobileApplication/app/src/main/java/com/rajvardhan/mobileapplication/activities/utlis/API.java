package com.rajvardhan.mobileapplication.activities.utlis;


import com.google.gson.JsonObject;
import com.rajvardhan.mobileapplication.activities.entities.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface API {
    @GET("/users")
    Call<JsonObject> getAllUsers();

    @POST("/users")
    Call<JsonObject> insertUser(@Body User user);

    @PUT("/users/{id}")
    Call<JsonObject> updateUser(@Body User user, @Path("id") int id);

    @DELETE("/users/{id}")
    Call<JsonObject> deleteUser(@Path("id") int id);

    @GET("/users/{id}")
    Call<JsonObject> getUserById(@Path("id") int id);
}