package com.example.general.day.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_WEATHER_ENTITY = "current_weather_entity"

@Entity(
    tableName = CURRENT_WEATHER_ENTITY
)
data class CurrentWeatherLocal(
    @PrimaryKey
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("code") val code: Int,
    @ColumnInfo("localCoordinates") val localCoordinates: CoordinatesLocal,
    @ColumnInfo("localWeatherTemperature") val localWeatherTemperature: WeatherTemperatureLocal,
    @ColumnInfo("name") val name: String,
)