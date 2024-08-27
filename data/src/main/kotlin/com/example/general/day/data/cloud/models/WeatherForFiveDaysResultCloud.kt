package com.example.general.day.data.cloud.models

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

data class WeatherForFiveDaysResultCloud(
    @SerializedName("clouds")
    val clouds: CloudsCloud,
    @SerializedName("dt")
    val time: Int,
    @SerializedName("dt_txt")
    val timeText: String,
    @SerializedName("main")
    val weatherTemperature: WeatherTemperatureCloud,
    @SerializedName("pop")
    val probabilityOfPrecipitation: Double,
    @SerializedName("rain")
    val rain: ForRainOrSnowCloud,
    @SerializedName("snow")
    val snow: ForRainOrSnowCloud,
    @SerializedName("sys")
    val systemInformation: WeatherSystemInformationCloud,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<WeatherCloud>,
    @SerializedName("wind")
    val wind: WindCloud
) {
    companion object {
        val unknown = WeatherForFiveDaysResultCloud(
            clouds = CloudsCloud(all = -1),
            time = -1,
            timeText = String(),
            weatherTemperature = WeatherTemperatureCloud.unknown,
            probabilityOfPrecipitation = 0.0,
            rain = ForRainOrSnowCloud(hour = 0.0),
            snow = ForRainOrSnowCloud(hour = 0.0),
            systemInformation = WeatherSystemInformationCloud(
                partOfDay = String(),
                sunset = 0,
                sunrise = 0
            ),
            visibility = -1,
            weather = emptyList(),
            wind = WindCloud(degrees = -1, speed = 0.0)
        )
    }
}

fun convertTimestampToDate(dt: Long): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val date = Date(dt * 1000)
    return dateFormat.format(date)
}

fun main() {
    val dt: Long = 1724706000
    val formattedDate = convertTimestampToDate(dt)
    println("Formatted date: $formattedDate")
}
