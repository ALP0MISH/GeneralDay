package com.example.general.day.presentation.di

import com.example.general.day.favorite.impl.FavoriteFeatureImpl
import com.example.general.day.home.impl.ui.HomeFeatureImpl

object DependencyProvider {

    fun favoriteScreen(): String = FavoriteFeatureImpl().favoriteRoute

    fun mapScreen(): String = ""

    fun homeFeature(): String = HomeFeatureImpl().homeRoute

    fun detailScreen(): String = ""
}
