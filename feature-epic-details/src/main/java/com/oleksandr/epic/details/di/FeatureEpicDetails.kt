package com.oleksandr.epic.details.di

import com.oleksandr.epic.details.screen.EpicDetailsViewModel
import com.oleksandr.epic.details.screen.contract.ViewState
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureEpicDetailsModule = module {
     viewModelOf(::EpicDetailsViewModel)
     factoryOf(ViewState::StateSaver)
}