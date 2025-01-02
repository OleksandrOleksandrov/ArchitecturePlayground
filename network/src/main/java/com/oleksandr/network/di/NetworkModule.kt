package com.oleksandr.network.di

import com.oleksandr.network.client
import org.koin.dsl.module

val networkModule = module {
    single { client() }
}