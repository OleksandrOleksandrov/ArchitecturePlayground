package com.oleksandr.epic.details.di

import com.oleksandr.epic.details.mapper.EPICDomainUiModelMapper
import com.oleksandr.epic.details.screen.EpicDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val featureEpicDetailsModule = module {
     viewModelOf(::EpicDetailsViewModel)
     singleOf(::EPICDomainUiModelMapper)
}