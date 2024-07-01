package com.example.general.day.home.impl

import androidx.compose.runtime.Immutable
import com.example.general.day.home.impl.models.CurrentWeatherHomeUi
import com.example.general.day.home.impl.models.WeatherForFiveDaysHomeUi

@Immutable
sealed class HomeUiState {

    data object Loading : HomeUiState()

    data class Loaded(
        val currentWeather: CurrentWeatherHomeUi,
        val weatherForFiveDays: WeatherForFiveDaysHomeUi,
    ) : HomeUiState()

    data class Error(
        val message: String,
    ) : HomeUiState()
}