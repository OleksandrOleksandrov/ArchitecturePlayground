package com.oleksandr.epic.di

import com.oleksandr.epic.screen.EPICViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val featureEarthPolychromaticImagingCameraModule = module {
     viewModelOf(::EPICViewModel)
}