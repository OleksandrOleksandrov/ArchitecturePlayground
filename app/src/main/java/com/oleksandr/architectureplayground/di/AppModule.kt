package com.oleksandr.architectureplayground.di

import com.oleksandr.architectureplayground.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ViewModel(get(), get()) }
}