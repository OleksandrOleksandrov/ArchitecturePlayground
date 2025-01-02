package com.oleksandr.architectureplayground

import android.app.Application
import com.oleksandr.architectureplayground.di.appModule
import com.oleksandr.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    networkModule,
                )
            )
        }
    }
}