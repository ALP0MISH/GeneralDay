package com.example.general.day.detail.impl

import android.annotation.SuppressLint
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.general.day.core.viewModel.component.Inject
import com.example.general.day.core.viewModel.component.daggerViewModel
import com.example.general.day.detail.api.DetailFeatureRouteProvider
import com.example.general.day.detail.api.DetailFeatureUiApi
import com.example.general.day.detail.impl.di.modules.DetailRoute
import com.example.general.day.detail.impl.ui.DetailScreen
import com.example.general.day.detail.impl.ui.DetailViewModel
import com.example.general.day.detail.impl.ui.DetailViewModelFactory
import javax.inject.Inject
import javax.inject.Provider

private const val argumentKey = "arg"

class DetailFeatureImpl @Inject constructor(
    private val route: DetailRoute,
    private val viewModelProvider: Provider<DetailViewModelFactory>
) : DetailFeatureUiApi {

    override val detailFeatureRouteProvider: DetailFeatureRouteProvider =
        object : DetailFeatureRouteProvider {
            override fun getDetailRoute(): String = route
        }

    @SuppressLint("ComposableDestinationInComposeScope")
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        theme: Boolean,
        onThemeChange: (Boolean) -> Unit,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(
            route = "$route/{$argumentKey}",
            arguments = listOf(navArgument(argumentKey) { type = NavType.StringType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val weatherId = arguments.getString(argumentKey).orEmpty()

            Inject(viewModelFactory = viewModelProvider.get()) {
                val viewModel: DetailViewModel = daggerViewModel()
                viewModel.setWeatherId(weatherId)
                DetailScreen(
                    uiStateFlow = viewModel.state,
                    onEvent = viewModel::onEvent,
                    onThemeChange = onThemeChange,
                    isDarkTheme = theme,
                    onNavigateToBack = navController::navigateUp
                )
            }
        }
    }
}