package com.example.general.day.home.impl.ui.di.modules

import androidx.lifecycle.ViewModel
import com.example.general.day.home.impl.ui.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.internal.Provider

@Module
class ViewModelMapModule {

    @Provides
    fun provideViewModelMap(
        homeViewModel: HomeViewModel
    ): Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>> {
        return mapOf(
            HomeViewModel::class.java to Provider { homeViewModel }
        )
    }
}
