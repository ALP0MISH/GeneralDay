package com.example.general.day.home.impl.ui.di

import androidx.lifecycle.ViewModel
import com.example.general.day.core.viewModel.component.ViewModelKey
import com.example.general.day.home.impl.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}