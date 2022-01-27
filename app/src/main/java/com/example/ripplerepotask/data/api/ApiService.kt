package com.example.ripplerepotask.data.api

import com.example.ripplerepotask.data.model.RepoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    companion object{
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("search/repositories")
    //@Headers("Authorization: token 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")
    fun getDataFromApi(
        @Query("q") query: String
    ): Call<RepoResponse>
}