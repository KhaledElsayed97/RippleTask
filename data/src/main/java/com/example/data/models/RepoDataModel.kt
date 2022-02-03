package com.example.data.models

import com.example.domain.models.Owner

data class RepoDataModel(
val name : String,
val description : String,
val owner: Owner
)
