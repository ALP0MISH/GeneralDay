package com.example.general.day.home.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.home.api.HomeFeatureApi

private const val baseRoute = "home"
private const val scenarioABRoute = "$baseRoute/scenario"
private const val screenBRoute = "$scenarioABRoute/B"
private const val screenARoute = "$scenarioABRoute/A"
private const val argumentKey = "arg"

object HomeFeatureImpl : HomeFeatureApi {

    override val homeRoute = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(homeRoute) {
            HomeScreen()
        }
    }
}