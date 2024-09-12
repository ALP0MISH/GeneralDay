package com.example.general.day.core

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureApi {

    fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        theme: Boolean,
        onThemeChange: (Boolean) -> Unit,
        modifier: Modifier = Modifier
    )
}