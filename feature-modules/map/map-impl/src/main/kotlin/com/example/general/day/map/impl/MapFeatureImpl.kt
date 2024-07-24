package com.example.general.day.map.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.general.day.core.FeatureApi
import com.example.general.day.map.api.MapFeatureApi

class MapFeatureImpl : MapFeatureApi {

    override val homeRoute: String = "map"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(homeRoute) {

        }
    }
}