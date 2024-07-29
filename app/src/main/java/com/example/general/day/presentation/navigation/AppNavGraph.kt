package com.example.general.day.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.general.day.core.FeatureApi
import com.example.general.day.presentation.di.DependencyProvider

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    featureApi: List<FeatureApi>,
    dependencyProvider: DependencyProvider
) {
    NavHost(
        navController = navController,
        startDestination = dependencyProvider.homeFeatureApi().homeRouteProvider.getRoute()
    ) {
        featureApi.forEach { api ->
            api.registerGraph(
                navController = navController,
                modifier = modifier,
                navGraphBuilder = this
            )
        }
    }
}