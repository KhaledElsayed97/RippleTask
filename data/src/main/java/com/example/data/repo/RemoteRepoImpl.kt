package com.example.data.repo


import com.example.data.apiservice.ApiService
import com.example.domain.entities.RepoResponse
import com.example.domain.entities.Repository
import com.example.domain.repositories.RemoteRepo
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(private val apiInstance: ApiService) : RemoteRepo {
    override suspend fun getRepos(query: String) : Observable<RepoResponse> {
        return apiInstance.getDataFromApi(query)
    }
}