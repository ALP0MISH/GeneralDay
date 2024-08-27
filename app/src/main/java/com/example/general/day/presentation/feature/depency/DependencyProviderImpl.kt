package com.example.general.day.presentation.feature.depency

import com.example.general.day.detail.api.DetailFeatureUiApi
import com.example.general.day.favorite.api.FavoriteFeatureUIApi
import com.example.general.day.home.api.HomeFeatureUiApi
import com.example.general.day.map.api.MapFeatureUiApi
import com.example.general.day.presentation.di.DependencyProvider
import javax.inject.Inject

class DependencyProviderImpl @Inject constructor(
    private val homeFeatureUiApi: HomeFeatureUiApi,
    private val favoriteFeatureApi: FavoriteFeatureUIApi,
    private val mapFeatureApi: MapFeatureUiApi,
    private val detailFeatureApi: DetailFeatureUiApi
) : DependencyProvider {

    override fun homeFeatureApi(): HomeFeatureUiApi = homeFeatureUiApi

    override fun favoriteFeatureApi(): FavoriteFeatureUIApi = favoriteFeatureApi

    override fun mapFeatureApi(): MapFeatureUiApi = mapFeatureApi

    override fun detailFeatureApi(): DetailFeatureUiApi = detailFeatureApi
}