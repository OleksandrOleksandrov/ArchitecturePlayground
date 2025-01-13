package com.oleksandr.database.impl.di

import com.oleksandr.database.impl.PlaygroundDatabase
import com.oleksandr.database.impl.source.EPICDbDataSourceImpl
import com.oleksandr.database.impl.source.dao.EPICDao
import com.oleksandr.database.source.datasource.EPICDbDataSource
import org.koin.dsl.module

val dbModule = module {
    single { PlaygroundDatabase.getDb(get()) }

    single<EPICDao> { PlaygroundDatabase.getDb(get()).epicDao() }
    single<EPICDbDataSource> { EPICDbDataSourceImpl(get()) }
}