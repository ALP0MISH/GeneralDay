package com.example.general.day.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.general.day.core.register
import com.example.general.day.presentation.di.DependencyProvider

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = DependencyProvider.homeFeature().homeRoute
    ) {

        register(
            DependencyProvider.homeFeature(),
            navController = navController,
            modifier = modifier
        )

        register(
            DependencyProvider.favoriteFeatureApi(),
            navController = navController,
            modifier = modifier
        )
    }
}
