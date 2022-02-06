package com.example.domain.repositories

import com.example.domain.models.RepoResponse
import com.example.domain.models.Repository
import io.reactivex.Observable
import retrofit2.Call

interface RemoteRepo {

    fun getRepos(query:String) : Observable<List<Repository>>
}