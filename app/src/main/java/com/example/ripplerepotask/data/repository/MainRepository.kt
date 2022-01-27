package com.example.ripplerepotask.data.repository


import com.example.ripplerepotask.data.api.ApiService
import com.example.ripplerepotask.data.api.ApiServiceImpl
import com.example.ripplerepotask.data.model.RepoResponse
import retrofit2.Call

class MainRepository (private val apiServiceImpl: ApiServiceImpl) {

    fun getRepos(query: String) : Call<RepoResponse> {
        return apiServiceImpl.apiInstance.getDataFromApi(query)
    }
}