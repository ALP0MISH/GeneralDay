package com.example.general.day.presentation.di

import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.FavoriteFeatureImpl
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.HomeFeatureImpl

object DependencyProvider {

    private lateinit var appComponent: AppComponent

    fun homeFeature(): HomeFeatureApi = appComponent.provideHomeFeatureApi()

    fun favoriteFeatureApi(): FavoriteFeatureApi = appComponent.provideFavoriteFeatureApi()
}
