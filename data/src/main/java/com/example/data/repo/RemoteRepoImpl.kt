package com.example.data.repo


import com.example.data.di.ApiServiceImpl
import com.example.domain.models.RepoResponse
import com.example.domain.repositories.RemoteRepo
import retrofit2.Call

class RemoteRepoImpl (private val apiServiceImpl: ApiServiceImpl) : RemoteRepo {

    override fun getRepos(query: String) : Call<RepoResponse> {
        return apiServiceImpl.apiInstance.getDataFromApi(query)
    }
}