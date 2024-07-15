package com.example.general.day.home.impl.ui

sealed class HomeScreenEvent {
    data object DoRefreshAllData : HomeScreenEvent()
    data class DoNavigateToDetailScreen(val weatherId: String) : HomeScreenEvent()
    data object DoNavigateToMapScreen : HomeScreenEvent()
    data object DoNavigateToFavoriteScreen : HomeScreenEvent()
    data object DoChangeTheme : HomeScreenEvent()
}