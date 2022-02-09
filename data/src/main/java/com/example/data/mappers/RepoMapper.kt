package com.example.data.mappers

import com.example.data.models.RepoDataModel
import com.example.domain.entities.Repository
import javax.inject.Inject

class RepoMapper @Inject constructor() {

    fun toRepoDetails(repoDataModel: RepoDataModel) : Repository{

        return Repository(
            repoDataModel.name,
            repoDataModel.description,
            repoDataModel.owner
        )

    }
}