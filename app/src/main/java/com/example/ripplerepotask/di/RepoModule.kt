package com.example.ripplerepotask.di

import com.example.data.repo.RemoteRepoImpl
import com.example.domain.repositories.RemoteRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun provideRemoteRepo(remoteRepoImpl: RemoteRepoImpl) : RemoteRepo
}