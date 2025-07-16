package com.oleksandr.epic.di

import com.oleksandr.epic.usecase.EPICDataListFlowUseCase
import com.oleksandr.epic.usecase.UpdateEPICUseCase
import com.oleksandr.epic.usecase.impl.EPICDataListFlowUseCaseImpl
import com.oleksandr.epic.usecase.impl.UpdateEPICUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainEpicModule = module {
    singleOf(::UpdateEPICUseCaseImpl) bind UpdateEPICUseCase::class
    singleOf(::EPICDataListFlowUseCaseImpl) bind EPICDataListFlowUseCase::class
}