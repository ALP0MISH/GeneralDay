package com.example.general.day.detail.impl.ui

sealed class DetailEvent {
    data object DoNavigateToMapScreen : DetailEvent()
    data object DoNavigateToFavoriteScreen : DetailEvent ()
    data object DoRetryFetchWeather : DetailEvent()
}