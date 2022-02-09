package com.example.domain.repositories

import com.example.domain.entities.RepoResponse
import com.example.domain.entities.Repository
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call

interface RemoteRepo {

    suspend fun getRepos(query:String) : Observable<RepoResponse>
}