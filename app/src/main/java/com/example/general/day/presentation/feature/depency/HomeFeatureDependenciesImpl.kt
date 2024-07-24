package com.example.general.day.presentation.feature.depency

import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies
import com.example.general.day.presentation.di.DependencyProvider
import javax.inject.Inject

class HomeFeatureDependenciesImpl @Inject constructor(
    private val dependencyProvider: DependencyProvider
) : HomeFeatureDependencies {

    override fun getDetailRoute(weatherId: String): String {
        return dependencyProvider.favoriteFeatureApi().favoriteRoute
    }

    override fun getFavoriteRoute(): String {
        return dependencyProvider.favoriteFeatureApi().favoriteRoute
    }

    override fun getMapRoute(): String {
        return dependencyProvider.mapFeatureApi().homeRoute
    }
}