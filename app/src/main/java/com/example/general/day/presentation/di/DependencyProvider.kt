package com.example.general.day.presentation.di

import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.home.api.HomeFeatureUiApi
import com.example.general.day.map.api.MapFeatureApi

interface DependencyProvider {

    fun homeFeatureApi(): HomeFeatureUiApi

    fun favoriteFeatureApi(): FavoriteFeatureApi

    fun mapFeatureApi(): MapFeatureApi
}
