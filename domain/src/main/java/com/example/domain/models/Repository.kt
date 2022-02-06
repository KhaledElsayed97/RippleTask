package com.example.domain.models

data class RepoResponse(
    val items: List<Repository>
)

data class Repository(

    val name : String,
    val description : String,
    val owner: Owner

)

data class Owner(val avatar_url: String)

