package com.example.general.day.presentation.di

import androidx.lifecycle.ViewModelProvider
import com.example.general.day.core.viewModel.component.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}