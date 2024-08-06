package com.example.general.day.map.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.core.viewModel.component.DaggerViewModelFactory
import com.example.general.day.core.viewModel.component.Inject
import com.example.general.day.map.api.MapFeatureUiApi
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.map.impl.di.modules.MapRoute
import javax.inject.Inject

class MapFeatureImpl @Inject constructor(
    private val route: MapRoute,
    private val viewModelFactory: DaggerViewModelFactory
) : MapFeatureUiApi {

    override val mapRouteProvider: MapRouteProvider = object : MapRouteProvider {
        override fun getRoute(): String = route
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route) {
            Inject(viewModelFactory = viewModelFactory) {

            }
        }
    }
}