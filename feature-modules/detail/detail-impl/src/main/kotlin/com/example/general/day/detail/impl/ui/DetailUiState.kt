package com.example.general.day.detail.impl.ui

import androidx.compose.runtime.Immutable
import com.example.general.day.ui.components.models.WeatherForDetail

@Immutable
sealed class DetailUiState {
    data object Loading : DetailUiState()

    @Immutable
    data class Loaded(
        val weatherForFiveDays: WeatherForDetail,
    ) : DetailUiState()

    @Immutable
    data class Error(
        val message: String,
    ) : DetailUiState()
}