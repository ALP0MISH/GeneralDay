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
    @ColumnInfo("lat") val lat: Double,
    @ColumnInfo("lon") val lon: Double,
    @ColumnInfo("feelsLike") val feelsLike: Double,
    @ColumnInfo("temperature")  val temperature: Double,
    @ColumnInfo("tempMax")  val tempMax: Double,
    @ColumnInfo("tempMin") val tempMin: Double,
    @ColumnInfo("name") val name: String,
)