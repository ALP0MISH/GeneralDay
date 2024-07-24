package com.example.general.day.home.impl.ui

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.core.viewModel.component.DaggerViewModelFactory
import com.example.general.day.core.viewModel.component.Inject
import com.example.general.day.core.viewModel.component.daggerViewModel
import com.example.general.day.home.api.HomeFeatureApi
import com.example.general.day.home.impl.ui.di.HomeComponent
import javax.inject.Inject

class HomeFeatureImpl @Inject constructor(
    private val homeComponentFactory: HomeComponent.Factory
) : HomeFeatureApi {

    override val homeRoute = "home"

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    init {
        val homeComponent = homeComponentFactory.create()
        homeComponent.inject(this)
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(homeRoute) {
            Inject(viewModelFactory = viewModelFactory) {
                val viewModel: HomeViewModel = daggerViewModel()
                HomeScreen(
                    uiStateFlow = viewModel.state,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}