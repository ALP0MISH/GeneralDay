package com.example.general.day.favorite.impl.ui

sealed class FavoriteEvent {
    data object DoNavigateToBack : FavoriteEvent()
    data object DoNavigateToSun : FavoriteEvent()
    data object DoNavigateToMapScreen : FavoriteEvent()
}