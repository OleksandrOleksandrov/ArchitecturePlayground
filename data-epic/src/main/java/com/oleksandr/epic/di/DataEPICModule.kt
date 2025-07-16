package com.oleksandr.epic.di

import com.oleksandr.epic.mapper.EPICDbRepoModelMapper
import com.oleksandr.epic.repository.EPICRepository
import com.oleksandr.epic.repository.impl.EPICRepositoryImpl
import com.oleksandr.epic.source.EPICNetSource
import com.oleksandr.epic.source.impl.EPICNetSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataEpicModule = module {
    single<EPICNetSource> { EPICNetSourceImpl(get()) }
    singleOf(::EPICRepositoryImpl) bind EPICRepository::class
    single { EPICDbRepoModelMapper() }
}