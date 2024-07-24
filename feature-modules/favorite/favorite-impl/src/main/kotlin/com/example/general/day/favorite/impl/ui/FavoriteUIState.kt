package com.example.general.day.favorite.impl.ui

import androidx.compose.runtime.Immutable
import com.example.general.day.ui.components.models.CurrentWeatherLocalUi
import com.example.general.day.ui.components.models.SearchWeatherUi
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
sealed class FavoriteUIState {

    data object Loading : FavoriteUIState()

    @Immutable
    data class Error(
        val message: String
    ) : FavoriteUIState()

    @Immutable
    data class Loaded(
        val searchWeather: ImmutableList<SearchWeatherUi> = persistentListOf(),
        val isLoading: Boolean = false,
        val query: String = String(),
        val savedWeather: ImmutableList<CurrentWeatherLocalUi> = persistentListOf(),
    ) : FavoriteUIState()
}