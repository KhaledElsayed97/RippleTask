package com.example.data.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceImpl {

    val retrofit = Retrofit.Builder()
        .baseUrl(com.example.data.apiservice.ApiService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInstance = retrofit.create(com.example.data.apiservice.ApiService::class.java)
}