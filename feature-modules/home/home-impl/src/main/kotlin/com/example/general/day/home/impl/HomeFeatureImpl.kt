package com.example.general.day.home.impl

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.core.IdResourceString
import com.example.general.day.`feature-modules`.home.impl.R
import com.example.general.day.home.api.HomeFeatureApi

object HomeFeatureImpl : HomeFeatureApi {

    override val homeRoute: IdResourceString = IdResourceString(R.string.home_screen_rout)

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route = homeRoute.format()) {
            HomeScreen()
        }
    }
}