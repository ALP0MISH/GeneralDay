package com.example.general.day.presentation.navigation

import javax.inject.Inject

class StartDestinationProviderImpl @Inject constructor(
    private val dependencyProvider: DependencyProvider
) : StartDestinationProvider {

    override fun getRoute(): String = dependencyProvider
        .homeFeatureApi()
        .homeRouteProvider
        .getRoute()
}