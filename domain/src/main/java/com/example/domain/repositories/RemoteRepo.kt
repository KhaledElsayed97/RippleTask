package com.example.domain.repositories

import com.example.domain.models.RepoResponse
import com.example.domain.models.Repository
import retrofit2.Call

interface RemoteRepo {

    fun getRepos(query:String) : Call<RepoResponse>
}