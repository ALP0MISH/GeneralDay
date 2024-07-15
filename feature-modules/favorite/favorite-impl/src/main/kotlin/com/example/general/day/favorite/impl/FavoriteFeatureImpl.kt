package com.example.general.day.favorite.impl

import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.core.FeatureApi
import com.example.general.day.favorite.api.FavoriteFeatureApi
import com.example.general.day.favorite.impl.di.FavoriteViewModelFactory
import com.example.general.day.favorite.impl.ui.FavoriteScreen
import com.example.general.day.favorite.impl.ui.FavoriteViewModel
import javax.inject.Inject

private const val baseRoute = "favorite"

class FavoriteFeatureImpl() : FavoriteFeatureApi {

    override val favoriteRoute = baseRoute

    @Inject
    lateinit var mapViewModelFactory: FavoriteViewModelFactory

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            val viewModel: FavoriteViewModel = viewModel(
                factory = mapViewModelFactory
            )
            FavoriteScreen(
                uiStateFlow = viewModel.uiState,
                onEvent = viewModel::onEvent
            )
        }
    }
}