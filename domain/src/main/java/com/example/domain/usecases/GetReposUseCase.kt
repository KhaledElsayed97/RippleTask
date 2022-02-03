package com.example.domain.usecases

import com.example.domain.models.RepoResponse
import com.example.domain.models.Repository
import com.example.domain.repositories.RemoteRepo
import retrofit2.Call

class GetReposUseCase (val apiRepo:RemoteRepo) : CallUseCase<RepoResponse>{
    override fun execute(q:String): Call<RepoResponse> {
        return apiRepo.getRepos(q)
    }
}