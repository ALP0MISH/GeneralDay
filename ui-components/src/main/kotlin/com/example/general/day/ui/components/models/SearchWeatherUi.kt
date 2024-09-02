package com.example.general.day.ui.components.models

import androidx.compose.runtime.Immutable
import com.example.general.day.domain.models.LocalNamesDomain

@Immutable
data class SearchWeatherUi(
    val country: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val state: String,
    val localName: LocalNamesUi
)