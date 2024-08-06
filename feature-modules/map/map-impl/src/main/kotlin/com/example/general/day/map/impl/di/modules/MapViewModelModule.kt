package com.example.general.day.map.impl.di.modules

import androidx.lifecycle.ViewModel
import com.example.general.day.core.viewModel.component.ViewModelKey
import com.example.general.day.map.impl.ui.MapViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MapViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    fun bindMapViewModel(mapViewModel: MapViewModel): ViewModel
}