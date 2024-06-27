package com.example.general.day.home.impl.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.general.day.core.viewModel.helper.DaggerViewModelFactory
import com.example.general.day.core.viewModel.helper.ViewModelFactory
import com.example.general.day.core.viewModel.helper.ViewModelKey
import com.example.general.day.home.impl.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    fun bindHomeViewModelFactory(factory: HomeViewModelFactory): ViewModelFactory<HomeViewModel>
}