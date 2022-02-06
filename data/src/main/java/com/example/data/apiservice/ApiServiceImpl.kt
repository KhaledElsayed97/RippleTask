package com.example.data.apiservice

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceImpl {

    val retrofit = Retrofit.Builder()
        .baseUrl(ApiService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    val apiInstance = retrofit.create(ApiService::class.java)
}