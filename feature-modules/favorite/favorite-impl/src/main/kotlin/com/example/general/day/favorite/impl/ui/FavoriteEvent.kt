package com.example.general.day.favorite.impl.ui

import androidx.compose.runtime.Immutable

@Immutable
sealed class FavoriteEvent {
    data class GetCityName(val cityName: String) : FavoriteEvent()
    data class DoOnValueChange(val value: String) : FavoriteEvent()
    data class DoSavedWeatherOnValueChange(val value: String) : FavoriteEvent()
    data object DoNavigateToBack : FavoriteEvent()
    data object DoNavigateToSun : FavoriteEvent()
    data object DoNavigateToMapScreen : FavoriteEvent()
    data object DoFetchCityName : FavoriteEvent()
}