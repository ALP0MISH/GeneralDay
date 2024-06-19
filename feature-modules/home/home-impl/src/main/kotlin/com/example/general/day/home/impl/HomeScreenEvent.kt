package com.example.general.day.home.impl

sealed class HomeScreenEvent {
    data object RefreshAllData : HomeScreenEvent()
    data object OnNavigateToDetailScreen : HomeScreenEvent()
    data object OnNavigateToMapScreen : HomeScreenEvent()
    data object OnNavigateToFavoriteScreen : HomeScreenEvent()
    data object OnNavigateToSearchScreen : HomeScreenEvent()
}