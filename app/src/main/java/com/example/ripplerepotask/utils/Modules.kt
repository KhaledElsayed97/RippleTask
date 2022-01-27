package com.example.ripplerepotask.data.model

import com.example.ripplerepotask.data.api.ApiServiceImpl
import com.example.ripplerepotask.data.repository.MainRepository
import com.example.ripplerepotask.ui.main.adapter.MainAdapter
import com.example.ripplerepotask.ui.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Response

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

    single { MainRepository(get()) }

    viewModel{ MainViewModel(get()) }
}