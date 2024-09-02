package com.example.general.day.home.impl.ui

sealed class HomeScreenEvent {
    data class DoNavigateToDetailScreen(val weatherId: String) : HomeScreenEvent()
    data object DoNavigateToMapScreen : HomeScreenEvent()
    data object DoNavigateToFavoriteScreen : HomeScreenEvent()
    data object DoRetryFetchWeather : HomeScreenEvent()
}