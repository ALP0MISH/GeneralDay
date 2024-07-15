package com.example.general.day.home.impl.ui.di

interface HomeFeatureDependencies {

    fun getDetailRoute(weatherId: String): String

    fun getFavoriteRoute(): String

    fun getMapRoute(): String
}