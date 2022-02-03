package com.example.ripplerepotask.data.model

import com.example.data.di.ApiServiceImpl
import com.example.data.repo.RemoteRepoImpl
import com.example.domain.models.Owner
import com.example.domain.models.RepoResponse
import com.example.domain.models.Repository
import com.example.ripplerepotask.ui.main.adapter.MainAdapter
import com.example.ripplerepotask.ui.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryResponseModule = module {

    factory { Owner(get()) }

    factory { Repository(get(),get(),get()) }

    factory { RepoResponse(get()) }
}

val adapterModule = module {

    single {ArrayList<Repository>()}
    factory { MainAdapter(get()) }
}

val retrofitBuilderModule = module{
    single{ ApiServiceImpl() }

    single { RemoteRepoImpl(get()) }

    viewModel{ MainViewModel(get()) }
}