package com.oleksandr.architectureplayground

import android.app.Application
import com.oleksandr.architectureplayground.di.appModule
import com.oleksandr.database.impl.di.dbModule
import com.oleksandr.epic.details.di.featureEpicDetailsModule
import com.oleksandr.apod.di.dataAPODModule
import com.oleksandr.apod.di.domainAPODModule
import com.oleksandr.epic.di.dataEpicModule
import com.oleksandr.epic.di.domainEpicModule
import com.oleksandr.epic.di.featureEarthPolychromaticImagingCameraModule
import com.oleksandr.impl.di.preferenceModule
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
                    featureEarthPolychromaticImagingCameraModule,
                    featureEpicDetailsModule,
                    dataEpicModule,
                    domainEpicModule,
                    domainAPODModule,
                    dbModule,
                    dataAPODModule,
                    preferenceModule,
                )
            )
        }
    }
}