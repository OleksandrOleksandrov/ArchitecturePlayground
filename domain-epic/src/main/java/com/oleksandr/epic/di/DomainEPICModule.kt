package com.oleksandr.epic.di

import com.oleksandr.epic.mapper.EPICDomainRepoModelMapper
import com.oleksandr.epic.usecase.EPICDataListFlowUseCase
import com.oleksandr.epic.usecase.UpdateEPICUseCase
import com.oleksandr.epic.usecase.impl.EPICDataListFlowUseCaseImpl
import com.oleksandr.epic.usecase.impl.UpdateEPICUseCaseImpl
import org.koin.dsl.module

val domainEpicModule = module {
    single<UpdateEPICUseCase> { UpdateEPICUseCaseImpl(get()) }
    single<EPICDataListFlowUseCase> { EPICDataListFlowUseCaseImpl(get(), get()) }
    single { EPICDomainRepoModelMapper() }
}