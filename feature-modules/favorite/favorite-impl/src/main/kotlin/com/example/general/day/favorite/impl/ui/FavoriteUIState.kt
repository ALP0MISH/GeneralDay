package com.example.general.day.favorite.impl.ui

import androidx.compose.runtime.Immutable
import com.example.general.day.ui.components.models.SavedWeatherUI
import com.example.general.day.ui.components.models.SearchWeatherUi
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class FavoriteUIState(
    val searchResult: ImmutableList<SearchWeatherUi> = persistentListOf(),
    val query: String = String(),
    val isLoading: Boolean = false,
    val error: String = String(),
    val savedWeatherUI: SavedWeatherUI = SavedWeatherUI.unknown,
)