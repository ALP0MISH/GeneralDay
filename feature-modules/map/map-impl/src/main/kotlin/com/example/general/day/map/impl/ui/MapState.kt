package com.example.general.day.map.impl.ui

import android.location.Location
import com.example.general.day.map.impl.ui.components.ZoneClusterItem
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi

data class MapState(
    val lastKnownLocation: Location? = null,
    val clusterItems: List<ZoneClusterItem> = emptyList(),
)