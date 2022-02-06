package com.example.domain.usecases

import com.example.domain.models.RepoResponse
import com.example.domain.models.Repository
import com.example.domain.repositories.RemoteRepo
import io.reactivex.Observable
import retrofit2.Call

class GetReposUseCase (val apiRepo:RemoteRepo){
     fun execute(q:String): Observable<List<Repository>> {
        return apiRepo.getRepos(q)
    }
}