package com.example.kotlinsingletondemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object MyRetrofitBuilder {

    val URL:String = "https://open-api.xyz/"

    val retrofitBuilderForOpenAPI_XYZ: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService:ApiService by lazy {
        retrofitBuilderForOpenAPI_XYZ
            .build()
            .create(ApiService::class.java)
    }


}