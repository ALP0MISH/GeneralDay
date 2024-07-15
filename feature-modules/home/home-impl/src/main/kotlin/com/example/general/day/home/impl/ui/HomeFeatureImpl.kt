package com.example.general.day.home.impl.ui

import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.di.HomeViewModelFactory
import javax.inject.Inject

const val baseRoute = "home"

class HomeFeatureImpl : HomeFeatureApi {

    override val homeRoute = baseRoute

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(homeRoute) {
            val viewModel: HomeViewModel = viewModel(
                factory = homeViewModelFactory
            )
            Home(
                uiStateFlow = viewModel.state,
                onEvent = viewModel::onEvent
            )
        }
    }
}