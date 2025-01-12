package com.oleksandr.epic.di

import com.oleksandr.epic.mapper.EPICDomainUiModelMapper
import com.oleksandr.epic.screen.EPICViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureEarthPolychromaticImagingCameraModule = module {
     viewModel { EPICViewModel(get(), get(), get()) }
     single { EPICDomainUiModelMapper() }
}