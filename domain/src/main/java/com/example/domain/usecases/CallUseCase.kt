package com.example.domain.usecases

import com.example.domain.models.RepoResponse
import com.example.domain.models.Repository
import retrofit2.Call

interface CallUseCase<Response> {

    fun execute(q:String) : Call<Response>
}