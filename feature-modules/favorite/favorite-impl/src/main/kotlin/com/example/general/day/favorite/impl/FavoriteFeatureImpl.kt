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

class FavoriteFeatureImpl : FavoriteFeatureApi {

    override val favoriteRoute = "favorite"

    @Inject
    lateinit var favoriteModelFactory: FavoriteViewModelFactory

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(favoriteRoute) {
            val viewModel: FavoriteViewModel = viewModel(
                factory = favoriteModelFactory
            )
            FavoriteScreen(
                uiStateFlow = viewModel.uiState,
                onEvent = viewModel::onEvent
            )
        }
    }
}