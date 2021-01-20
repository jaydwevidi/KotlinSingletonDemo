package com.example.kotlinsingletondemo.api

import com.example.kotlinsingletondemo.Modles.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService{
    @GET("placeholder/user/{userId}")
    suspend fun getUser(@Path("userId") userID:String):User
}