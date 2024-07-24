package com.example.general.day.presentation.feature.depency

import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.map.api.MapFeatureApi
import com.example.general.day.presentation.di.DependencyProvider

class DependencyProviderImpl(
    private val homeFeatureApi: HomeFeatureApi,
    private val favoriteFeatureApi: FavoriteFeatureApi,
    private val mapFeatureApi: MapFeatureApi
) : DependencyProvider {

    override fun homeFeatureApi(): HomeFeatureApi = homeFeatureApi

    override fun favoriteFeatureApi(): FavoriteFeatureApi = favoriteFeatureApi

    override fun mapFeatureApi(): MapFeatureApi = mapFeatureApi
}
