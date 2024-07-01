package com.example.general.day.home.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.home.api.HomeFeatureApi

private const val baseRoute = "home"

object HomeFeatureImpl : HomeFeatureApi {

    private lateinit var viewModel: HomeViewModel
    override val homeRoute = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(homeRoute) {
            Home(
                onEvent = viewModel::onEvent,
                uiStateFlow = viewModel.state
            )
        }
    }
}