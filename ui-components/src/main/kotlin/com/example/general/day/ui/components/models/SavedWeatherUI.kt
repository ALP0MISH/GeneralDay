package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class SavedWeatherUI(
    val query: String = String(),
    val savedWeather: ImmutableList<CurrentWeatherLocalUi> = persistentListOf(),
){
    companion object {
        val unknown = SavedWeatherUI(
            savedWeather = persistentListOf(),
            query = String()
        )
    }
}