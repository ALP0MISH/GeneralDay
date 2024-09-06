package com.example.general.day.map.impl

import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.core.viewModel.component.Inject
import com.example.general.day.core.viewModel.component.daggerViewModel
import com.example.general.day.map.api.MapFeatureUiApi
import com.example.general.day.map.api.MapRouteProvider
import com.example.general.day.map.impl.di.modules.MapRoute
import com.example.general.day.map.impl.ui.MapScreen
import com.example.general.day.map.impl.ui.MapViewModel
import com.example.general.day.map.impl.ui.MapViewModelFactory
import javax.inject.Inject
import javax.inject.Provider

class MapFeatureImpl @Inject constructor(
    private val route: MapRoute,
    private val viewModelProvider: Provider<MapViewModelFactory>
) : MapFeatureUiApi {

    override val mapRouteProvider: MapRouteProvider = object : MapRouteProvider {
        override fun getRoute(): String = route
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        theme: Boolean,
        onThemeChange: (Boolean) -> Unit,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route) {
            Inject(viewModelFactory = viewModelProvider.get()) {
                val viewModel: MapViewModel = daggerViewModel()
                MapScreen(
                    state = viewModel.state.collectAsStateWithLifecycle().value,
                    setupClusterManager = viewModel::setupClusterManager,
                    calculateZoneViewCenter = viewModel::calculateZoneLatLngBounds,
                    onMapClicked = viewModel::getWeatherForLocation,
                )
            }
        }
    }
}