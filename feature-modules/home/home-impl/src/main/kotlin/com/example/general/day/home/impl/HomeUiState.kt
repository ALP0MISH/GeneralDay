package com.example.general.day.home.impl

import androidx.compose.runtime.Immutable
import com.example.general.day.home.impl.models.CurrentWeatherHomeUi

@Immutable
sealed class HomeUiState {
    data object Loading : HomeUiState()

    data class Loaded(
        val weather: CurrentWeatherHomeUi
    ) : HomeUiState()

    data class Error(
        val message: String,
    ) : HomeUiState()
}