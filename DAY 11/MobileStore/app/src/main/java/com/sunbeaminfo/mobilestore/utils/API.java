package com.sunbeaminfo.mobilestore.utils;

import com.google.gson.JsonObject;
import com.sunbeaminfo.mobilestore.entity.Order;
import com.sunbeaminfo.mobilestore.entity.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
    @POST("/users/login")
    Call<JsonObject> loginUser(@Body User user);

    @POST("/users")
    Call<JsonObject> registerUser(@Body User user);

    @GET("/mobiles")
    Call<JsonObject> getAllMobiles();

    @GET("/users/{id}")
    Call<JsonObject> getUserById(@Path("id") int id);

    @POST("/orders")
    Call<JsonObject> placeOrder(@Body Order order);

    @GET("/orders/user/{id}")
    Call<JsonObject> getAllOrders(@Path("id") int uid);

}
