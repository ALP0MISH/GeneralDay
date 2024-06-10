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
) {
    companion object {
        val unknown = CurrentWeatherLocal(
            id = -1,
            code = -1,
            localCoordinates = CoordinatesLocal(lat = 0.0, lon = 0.0),
            localWeatherTemperature = WeatherTemperatureLocal.unknown,
            name = String()
        )
    }
}
