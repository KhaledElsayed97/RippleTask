package com.example.domain.repositories

import com.example.domain.entities.RepoResponse
import retrofit2.Call

interface RemoteRepo {

    suspend fun getRepos(query:String) : Call<RepoResponse>
}