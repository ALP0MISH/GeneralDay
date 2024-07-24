package com.example.general.day.presentation.feature.depency

import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.home.api.HomeFeatureUiApi
import com.example.general.day.map.api.MapFeatureApi
import com.example.general.day.presentation.di.DependencyProvider

class DependencyProviderImpl(
    private val homeFeatureUiApi: HomeFeatureUiApi,
    private val favoriteFeatureApi: FavoriteFeatureApi,
    private val mapFeatureApi: MapFeatureApi
) : DependencyProvider {

    override fun homeFeatureApi(): HomeFeatureUiApi = homeFeatureUiApi

    override fun favoriteFeatureApi(): FavoriteFeatureApi = favoriteFeatureApi

    override fun mapFeatureApi(): MapFeatureApi = mapFeatureApi
}
