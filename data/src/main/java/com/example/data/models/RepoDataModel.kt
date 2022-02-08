package com.example.data.models

import com.example.domain.entities.Owner

data class RepoDataModel(
val name : String,
val description : String,
val owner: Owner
)
