package com.example.general.day.favorite.impl

import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.core.viewModel.component.Inject
import com.example.general.day.core.viewModel.component.daggerViewModel
import com.example.general.day.favorite.api.FavoriteFeatureUIApi
import com.example.general.day.favorite.api.FavoriteRouteProvider
import com.example.general.day.favorite.impl.di.modules.FavoriteRoute
import com.example.general.day.favorite.impl.ui.FavoriteScreen
import com.example.general.day.favorite.impl.ui.FavoriteViewModel
import com.example.general.day.favorite.impl.ui.FavoriteViewModelFactory
import javax.inject.Inject
import javax.inject.Provider

class FavoriteFeatureImpl @Inject constructor(
    private val route: FavoriteRoute,
    private val viewModelFactory: Provider<FavoriteViewModelFactory>
) : FavoriteFeatureUIApi {

    override val favoriteRouteProvider: FavoriteRouteProvider = object : FavoriteRouteProvider {
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
            Inject(viewModelFactory = viewModelFactory.get()) {
                val viewModel: FavoriteViewModel = daggerViewModel()
                FavoriteScreen(
                    uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
                    onEvent = viewModel::onEvent,
                    theme = theme,
                    onThemeChange = onThemeChange,
                )
            }
        }
    }
}