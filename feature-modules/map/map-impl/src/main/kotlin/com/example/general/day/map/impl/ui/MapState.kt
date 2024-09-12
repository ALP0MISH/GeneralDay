package com.example.general.day.map.impl.ui

import android.location.Location
import androidx.compose.runtime.Immutable
import com.example.general.day.ui.core.utils.ZoneClusterItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class MapState(
    val lastKnownLocation: Location? = null,
    val clusterItems: ImmutableList<ZoneClusterItem> = persistentListOf(),
    val cityName: String = String()
)