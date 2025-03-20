package com.oleksandr.impl.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.oleksandr.architectureplayground.data.preference.impl.model.PictureOfDayProtoModel
import com.oleksandr.data.preference.PictureOfDayDataSource
import com.oleksandr.impl.config.PreferenceConfig
import com.oleksandr.impl.datasource.PictureOfDayDataSourceImpl
import com.oleksandr.impl.serializer.PictureOfDaySerializer
import com.oleksandr.impl.source.PictureOfDayPreferenceDao
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

private val pictureOfDayQualifier = named("PictureOfDayDataStore")

val preferenceModule = module {
    single<DataStore<PictureOfDayProtoModel>>(pictureOfDayQualifier) {
        val applicationContext: Context = get()
        val referralSerializer: PictureOfDaySerializer = get()

        DataStoreFactory.create(
            serializer = referralSerializer,
        ) {
            applicationContext.dataStoreFile(PreferenceConfig.Filename.PICTURE_OF_DAY)
        }
    }
    single { PictureOfDayPreferenceDao(get(pictureOfDayQualifier)) }
    singleOf(::PictureOfDayDataSourceImpl) bind PictureOfDayDataSource::class
    singleOf(::PictureOfDaySerializer)
}