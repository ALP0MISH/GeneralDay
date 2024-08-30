package com.example.general.day.favorite.impl.ui

import androidx.compose.runtime.Immutable

@Immutable
sealed class FavoriteEvent {
    data class DoNavigateToDetailScreen(val weatherId: String) : FavoriteEvent()
    data class GetCityName(val cityName: String) : FavoriteEvent()
    data class DoSavedWeatherOnValueChange(val value: String) : FavoriteEvent()
    data class DoDeleteWeatherById(val id: String) : FavoriteEvent()
    data object DoNavigateToMapScreen : FavoriteEvent()
    data object DoFetchCityName : FavoriteEvent()
}