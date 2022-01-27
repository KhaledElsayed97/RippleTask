package com.example.ripplerepotask

import android.app.Application
import com.example.ripplerepotask.data.model.adapterModule
import com.example.ripplerepotask.data.model.repositoryResponseModule
import com.example.ripplerepotask.data.model.retrofitBuilderModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApp)
            modules(listOf(retrofitBuilderModule,repositoryResponseModule,adapterModule))

        }
    }
}