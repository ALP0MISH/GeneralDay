package com.example.general.day.map.impl.ui

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.example.general.day.ui.core.theme.dp16
import com.example.general.day.ui.core.theme.dp20
import com.example.general.day.ui.core.theme.dp32
import com.example.general.day.ui.core.theme.dp8
import com.example.general.day.ui.core.utils.ZoneClusterItem
import com.example.general.day.ui.core.utils.ZoneClusterManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapEffect
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapsComposeExperimentalApi
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.launch

@SuppressLint("PotentialBehaviorOverride")
@OptIn(MapsComposeExperimentalApi::class)
@Composable
fun MapScreen(
    state: MapState,
    setupClusterManager: (GoogleMap) -> ZoneClusterManager,
    calculateZoneViewCenter: () -> LatLngBounds,
    onMapClicked: (LatLng) -> Unit,
    onNavigateToBack: () -> Unit,
) {
    val mapProperties = MapProperties(
        isMyLocationEnabled = state.lastKnownLocation != null,
    )
    val cameraPositionState = rememberCameraPositionState()
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = mapProperties,
            cameraPositionState = cameraPositionState
        ) {
            MapEffect(state.clusterItems) { map ->
                if (state.clusterItems.isNotEmpty()) {
                    val clusterManager = setupClusterManager(map)
                    map.setOnCameraIdleListener(clusterManager)
                    map.setOnMarkerClickListener(clusterManager)
                    state.clusterItems.forEach { clusterItem ->
                        map.addMarker(createMarkerOptions(clusterItem))
                    }
                    map.setOnMapLoadedCallback {
                        if (state.clusterItems.isNotEmpty()) {
                            scope.launch {
                                cameraPositionState.animate(
                                    update = CameraUpdateFactory.newLatLngBounds(
                                        calculateZoneViewCenter(),
                                        0
                                    ),
                                )
                            }
                        }
                    }
                }
                map.setOnMapClickListener { latLng ->
                    onMapClicked(latLng)
                }
            }
            MarkerInfoWindow(
                state = rememberMarkerState(
                    position = LatLng(
                        state.lastKnownLocation?.latitude ?: 0.0,
                        state.lastKnownLocation?.longitude ?: 0.0
                    )
                ),
                snippet = state.clusterItems.firstOrNull()?.snippet,
                onClick = {
                    true
                },
                draggable = true
            )
        }
        Text(
            modifier = Modifier
                .padding(top = dp20)
                .align(Alignment.TopCenter),
            text = state.cityName,
            style = MaterialTheme.typography.titleSmall,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold
        )
        Box(
            modifier = Modifier
                .padding(dp16)
                .size(dp32)
                .align(Alignment.TopStart)
                .clip(RoundedCornerShape(dp8))
                .background(Color.White)
                .clickable { onNavigateToBack() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
            )
        }
    }
}

private fun createMarkerOptions(
    clusterItem: ZoneClusterItem,
): MarkerOptions {

    return MarkerOptions()
        .position(clusterItem.position)
        .title(clusterItem.title)
        .snippet(clusterItem.snippet)
}


