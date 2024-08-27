package com.example.general.day.detail.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.detail.api.DetailFeatureRouteProvider
import com.example.general.day.detail.api.DetailFeatureUiApi
import com.example.general.day.detail.impl.di.modules.DetailRoute
import javax.inject.Inject

class DetailFeatureImpl @Inject constructor(
    private val route: DetailRoute
) : DetailFeatureUiApi {

    override val detailFeatureRouteProvider: DetailFeatureRouteProvider =
        object : DetailFeatureRouteProvider {
            override fun getDetailRoure(): String = route
        }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        theme: Boolean,
        onThemeChange: (Boolean) -> Unit,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route) {

        }
    }
}