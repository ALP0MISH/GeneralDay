package com.example.general.day.map.impl.ui

import android.content.Context
import android.graphics.Color
import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.general.day.map.impl.ui.components.ZoneClusterManager
import com.example.general.day.core.managers.LocationTrackerManager
import com.example.general.day.domain.use.case.FetchWeatherUseCase
import com.example.general.day.map.impl.ui.components.calculateCameraViewPoints
import com.example.general.day.map.impl.ui.components.getCenterOfPolygon
import com.example.general.day.ui.components.mappers.CurrentWeatherDomainToHomeUiMapper
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class MapViewModel @Inject constructor(
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val fetchLocationTrackerManager: LocationTrackerManager,
    private val currentWeatherDomainToHomeUiMapper: CurrentWeatherDomainToHomeUiMapper,
) : ViewModel() {

    private val _uiState = MutableStateFlow<MapState>(MapState())
    val state: StateFlow<MapState> = _uiState.asStateFlow()


    fun getWeatherForLocation(location: LatLng) {
        val latitude = location.latitude
        val longitude = location.longitude

        val lastKnownLocation = Location("provider_name").apply {
            this.latitude = latitude
            this.longitude = longitude
        }

        viewModelScope.launch {
            try {
                val result = fetchWeatherUseCase.fetchCurrentWeather(latitude, longitude)
                val weatherHelper = MapWeatherHelper().convertWeatherData(
                    currentWeatherDomainToHomeUiMapper.map(result), latitude, longitude
                )
                _uiState.tryEmit(
                    MapState(
                        lastKnownLocation = lastKnownLocation,
                        clusterItems = listOf(
                            weatherHelper
                        )
                    )
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                throw IllegalArgumentException("Error during API call: ${e.message}", e)
            }
        }
    }

    fun getDeviceLocation() {
        viewModelScope.launch {
            try {
                val location = fetchLocationTrackerManager.fetchCurrentLocation()
                if (location != null) {
                    _uiState.value = _uiState.value.copy(
                        lastKnownLocation = location,
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                throw IllegalArgumentException("Error during API call: ${e.message}", e)
            }
        }
    }

    fun setupClusterManager(
        context: Context,
        map: GoogleMap,
    ): ZoneClusterManager {
        val clusterManager = ZoneClusterManager(context, map)
        clusterManager.addItems(state.value.clusterItems)
        return clusterManager
    }

    fun calculateZoneLatLngBounds(): LatLngBounds {
        // Get all the points from all the polygons and calculate the camera view that will show them all.
        val latLngs = state.value.clusterItems.map { it.polygonOptions }
            .map { it.points.map { LatLng(it.latitude, it.longitude) } }.flatten()
        return latLngs.calculateCameraViewPoints().getCenterOfPolygon()
    }

    companion object {
        private val POLYGON_FILL_COLOR = Color.parseColor("#ABF44336")
    }
}