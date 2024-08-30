package com.example.general.day.home.impl.ui

import androidx.compose.runtime.Immutable
import com.example.general.day.ui.components.mappers.WeatherForFiveDaysResultDomainToUiMapper
import com.example.general.day.ui.components.models.CurrentConvertedWeather
import com.example.general.day.ui.components.models.WeatherForFiveDaysResultUi
import kotlinx.collections.immutable.ImmutableList

@Immutable
sealed class HomeUiState {

    data object Loading : HomeUiState()

    @Immutable
    data class Loaded(
        val weatherForFiveDays: ImmutableList<WeatherForFiveDaysResultUi>,
        val currentWeather: CurrentConvertedWeather
    ) : HomeUiState()

    @Immutable
    data class Error(
        val message: String,
    ) : HomeUiState()
}