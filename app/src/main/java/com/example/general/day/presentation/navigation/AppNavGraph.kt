package com.example.general.day.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.general.day.core.FeatureApi

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    featureApi: Set<FeatureApi>,
    startDestination: String,
    theme: Boolean,
    onThemeChange: (Boolean) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        featureApi.forEach { api ->
            api.registerGraph(
                navController = navController,
                modifier = modifier,
                navGraphBuilder = this,
                theme = theme,
                onThemeChange = onThemeChange
            )
        }
    }
}