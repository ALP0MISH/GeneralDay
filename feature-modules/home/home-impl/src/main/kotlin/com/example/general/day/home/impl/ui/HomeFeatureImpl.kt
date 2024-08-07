package com.example.general.day.home.impl.ui

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.core.viewModel.component.Inject
import com.example.general.day.core.viewModel.component.daggerViewModel
import com.example.general.day.home.api.HomeFeatureUiApi
import com.example.general.day.home.api.HomeRouteProvider
import com.example.general.day.home.impl.ui.di.modules.HomeRoute
import javax.inject.Inject
import javax.inject.Provider

class HomeFeatureImpl @Inject constructor(
    private val route: HomeRoute,
    private val viewModelProvider: Provider<HomeViewModelFactory>
) : HomeFeatureUiApi {

    override val homeRouteProvider: HomeRouteProvider = object : HomeRouteProvider {
        override fun getRoute(): String = route
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route) {
            Inject(viewModelFactory = viewModelProvider.get()) {
                val viewModel: HomeViewModel = daggerViewModel()
                HomeScreen(
                    uiStateFlow = viewModel.state,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}