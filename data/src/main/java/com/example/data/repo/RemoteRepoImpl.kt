package com.example.data.repo


import com.example.data.apiservice.ApiServiceImpl
import com.example.domain.models.RepoResponse
import com.example.domain.models.Repository
import com.example.domain.repositories.RemoteRepo
import io.reactivex.Observable
import retrofit2.Call
import javax.inject.Inject

class RemoteRepoImpl (val apiServiceImpl: ApiServiceImpl) : RemoteRepo {

    override fun getRepos(query: String) : Observable<List<Repository>> {
        return apiServiceImpl.apiInstance.getDataFromApi(query)
    }
}