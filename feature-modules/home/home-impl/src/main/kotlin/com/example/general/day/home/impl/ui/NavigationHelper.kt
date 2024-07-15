package com.example.general.day.home.impl.ui

import androidx.navigation.NavHostController
import com.example.general.day.home.impl.ui.di.HomeFeatureDependencies

class NavigationHelper(private val homeFeatureDependencies: HomeFeatureDependencies){

    fun navigateToDetailScreen(navHostController: NavHostController, weatherId: String) {
        navHostController.navigate(homeFeatureDependencies.getDetailRoute(weatherId))
    }

    fun navigateToFavoriteScreen(navHostController: NavHostController) {
        navHostController.navigate(homeFeatureDependencies.getFavoriteRoute())
    }

    fun navigateToMapScreen(navHostController: NavHostController) {
        navHostController.navigate(homeFeatureDependencies.getMapRoute())
    }

    fun refreshAllData() {

    }
}
