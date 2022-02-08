package com.example.domain.usecases

import com.example.domain.entities.RepoResponse
import com.example.domain.repositories.RemoteRepo
import retrofit2.Call

class GetReposUseCase (private val apiRepo:RemoteRepo){
    suspend operator fun invoke(query:String) = apiRepo.getRepos(query)
}