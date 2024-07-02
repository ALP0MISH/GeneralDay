package com.example.general.day.home.impl.ui

import androidx.compose.runtime.Immutable
import com.example.general.day.ui.components.models.ConvertedWeather
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import com.example.general.day.ui.components.models.WeatherForFiveDaysHomeUi
import kotlinx.collections.immutable.ImmutableList

@Immutable
sealed class HomeUiState {

    data object Loading : HomeUiState()

    @Immutable
    data class Loaded(
        val currentWeather: CurrentWeatherHomeUi,
        val weatherForFiveDays: WeatherForFiveDaysHomeUi,
        val convertedWeather: ImmutableList<ConvertedWeather>
    ) : HomeUiState()

    @Immutable
    data class Error(
        val message: String,
    ) : HomeUiState()
}