package com.oleksandr.epic.di

import com.oleksandr.epic.mapper.EPICModelMapper
import com.oleksandr.epic.repository.EPICRepository
import com.oleksandr.epic.repository.impl.EPICRepositoryImpl
import com.oleksandr.epic.source.EPICNetSource
import com.oleksandr.epic.source.impl.EPICNetSourceImpl
import org.koin.dsl.module

val dataEpicModule = module {
    single<EPICNetSource> { EPICNetSourceImpl(get()) }
    single<EPICRepository> { EPICRepositoryImpl(get(), get()) }
    single { EPICModelMapper() }
}