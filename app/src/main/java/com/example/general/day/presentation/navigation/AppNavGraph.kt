package com.example.general.day.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.general.day.core.register
import com.example.general.day.presentation.di.DependencyProvider

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    dependencyProvider: DependencyProvider
) {
    NavHost(
        navController = navController,
        startDestination = dependencyProvider.homeFeatureApi().homeRoute
    ) {
        register(
            dependencyProvider.homeFeatureApi(),
            navController = navController,
            modifier = modifier
        )
    }
}