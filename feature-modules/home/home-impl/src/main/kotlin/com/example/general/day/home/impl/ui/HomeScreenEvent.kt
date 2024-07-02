package com.example.general.day.home.impl.ui

sealed class HomeScreenEvent {
    data object DoRefreshAllData : HomeScreenEvent()
    data object DoNavigateToDetailScreen : HomeScreenEvent()
    data object DoNavigateToMapScreen : HomeScreenEvent()
    data object DoNavigateToFavoriteScreen : HomeScreenEvent()
    data object DoNavigateToSearchScreen : HomeScreenEvent()
}