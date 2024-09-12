package com.example.general.day.presentation.navigation

import com.example.general.day.detail.api.DetailFeatureUiApi
import com.example.general.day.favorite.api.FavoriteFeatureUIApi
import com.example.general.day.home.api.HomeFeatureUiApi
import com.example.general.day.map.api.MapFeatureUiApi

interface DependencyProvider {

    fun homeFeatureApi(): HomeFeatureUiApi

    fun favoriteFeatureApi(): FavoriteFeatureUIApi

    fun mapFeatureApi(): MapFeatureUiApi

    fun detailFeatureApi(): DetailFeatureUiApi
}