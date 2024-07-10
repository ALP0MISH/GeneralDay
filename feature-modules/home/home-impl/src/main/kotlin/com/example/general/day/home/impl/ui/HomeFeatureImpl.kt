package com.example.general.day.home.impl.ui

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.home.api.HomeFeatureApi

private const val baseRoute = "home"

class HomeFeatureImpl : HomeFeatureApi {

    override val homeRoute = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(homeRoute) {
        }
    }
}