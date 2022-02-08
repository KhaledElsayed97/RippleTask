package com.example.ripplerepotask.di

import android.content.Context
import com.example.data.apiservice.ApiService
import com.example.data.repo.RemoteRepoImpl
import com.example.domain.entities.Repository
import com.example.domain.repositories.RemoteRepo
import com.example.domain.usecases.GetReposUseCase
import com.example.ripplerepotask.BaseApp
import com.example.ripplerepotask.ui.main.adapter.MainAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 class AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context) : BaseApp {
        return app as BaseApp
    }

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(com.example.data.apiservice.ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideContext(application: BaseApp): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideList() : ArrayList<Repository>{
        return ArrayList<Repository>()
    }

    @Provides
    @Singleton
    fun provideAdapter(list:ArrayList<Repository>): MainAdapter {
        return MainAdapter(list)
    }

    @Provides
    @Singleton
    fun provideUseCase(apiRepo: RemoteRepo): GetReposUseCase {
        return GetReposUseCase(apiRepo)
    }

    @Provides
    @Singleton
    fun provideReposRepository(apiService:ApiService) : RemoteRepoImpl{
        return RemoteRepoImpl(apiService)
    }

}