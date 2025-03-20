package com.oleksandr.apod.di

import com.oleksandr.apod.repository.APODRepository
import com.oleksandr.apod.repository.impl.APODRepositoryImpl
import com.oleksandr.apod.source.APODNetSource
import com.oleksandr.apod.source.impl.APODNetSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataAPODModule = module {
    singleOf(::APODNetSourceImpl) bind APODNetSource::class
    singleOf(::APODRepositoryImpl) bind APODRepository::class
}