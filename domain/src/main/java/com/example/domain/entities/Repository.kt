package com.example.domain.entities

data class RepoResponse(
    val items: ArrayList<Repository>
)

data class Repository(

    val name : String,
    val description : String,
    val owner: Owner

)

data class Owner(val avatar_url: String)
