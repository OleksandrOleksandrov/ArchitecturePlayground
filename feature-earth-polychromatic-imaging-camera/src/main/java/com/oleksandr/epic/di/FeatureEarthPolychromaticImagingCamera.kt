package com.oleksandr.epic.di

import com.oleksandr.epic.screen.EPICViewModel
import com.oleksandr.epic.screen.contract.ViewState
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureEarthPolychromaticImagingCameraModule = module {
     viewModelOf(::EPICViewModel)
     factoryOf(ViewState::StateSaver)
}