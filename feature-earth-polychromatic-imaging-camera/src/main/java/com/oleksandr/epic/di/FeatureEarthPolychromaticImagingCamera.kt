package com.oleksandr.epic.di

import com.oleksandr.epic.mapper.EPICDomainUiModelMapper
import com.oleksandr.epic.screen.EPICViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val featureEarthPolychromaticImagingCameraModule = module {
     viewModelOf(::EPICViewModel)
     singleOf(::EPICDomainUiModelMapper)
}