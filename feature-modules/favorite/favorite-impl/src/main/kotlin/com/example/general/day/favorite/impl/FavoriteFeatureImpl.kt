package com.example.general.day.favorite.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.core.viewModel.component.DaggerViewModelFactory
import com.example.general.day.core.viewModel.component.Inject
import com.example.general.day.core.viewModel.component.daggerViewModel
import com.example.general.day.favorite.api.FavoriteFeatureUIApi
import com.example.general.day.favorite.api.FavoriteRouteProvider
import com.example.general.day.favorite.impl.di.modules.FavoriteRoute
import com.example.general.day.favorite.impl.ui.FavoriteScreen
import com.example.general.day.favorite.impl.ui.FavoriteViewModel
import javax.inject.Inject

class FavoriteFeatureImpl @Inject constructor(
    private val route: FavoriteRoute,
    private val viewModelFactory: DaggerViewModelFactory
) : FavoriteFeatureUIApi {

    override val favoriteRouteProvider: FavoriteRouteProvider = object : FavoriteRouteProvider {
        override fun getRoute(): String = route
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route) {
            Inject(viewModelFactory = viewModelFactory) {
                val viewModel: FavoriteViewModel = daggerViewModel()
                FavoriteScreen(
                    uiStateFlow = viewModel.uiState,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}