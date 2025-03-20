package com.oleksandr.apod.di

import com.oleksandr.apod.usecase.APODDataFlowUseCase
import com.oleksandr.apod.usecase.UpdateAPODUseCase
import com.oleksandr.apod.usecase.impl.APODDataFlowUseCaseImpl
import com.oleksandr.apod.usecase.impl.UpdateAPODUseCaseImpl
import org.koin.dsl.module

val domainAPODModule = module {
    single<UpdateAPODUseCase> { UpdateAPODUseCaseImpl(get()) }
    single<APODDataFlowUseCase> { APODDataFlowUseCaseImpl(get()) }
}