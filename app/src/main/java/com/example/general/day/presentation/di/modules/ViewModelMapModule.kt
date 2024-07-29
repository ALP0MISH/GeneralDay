package com.example.general.day.presentation.di.modules

import androidx.lifecycle.ViewModel
import com.example.general.day.favorite.impl.ui.FavoriteViewModel
import com.example.general.day.home.impl.ui.HomeViewModel
import com.example.general.day.map.impl.ui.MapViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module
class ViewModelMapModule {

    @Provides
    @Singleton
    fun provideViewModelMap(
        homeViewModel: HomeViewModel,
        favoriteViewModel: FavoriteViewModel,
        mapViewModel: MapViewModel
    ): Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>> {
        return mapOf(
            HomeViewModel::class.java to Provider { homeViewModel },
            FavoriteViewModel::class.java to Provider { favoriteViewModel },
            MapViewModel::class.java to Provider { mapViewModel }
        )
    }
}
