package com.example.general.day.favorite.impl.di

import androidx.lifecycle.ViewModel
import com.example.general.day.core.viewModel.component.ViewModelKey
import com.example.general.day.favorite.impl.ui.FavoriteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface FavoriteViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    fun bindFavoriteViewModel(myViewModel: FavoriteViewModel): ViewModel
}