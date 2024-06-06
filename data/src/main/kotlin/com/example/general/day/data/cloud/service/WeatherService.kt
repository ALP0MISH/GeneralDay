package com.example.general.day.data.cloud.service

import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponseCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val FETCH_CURRENT_WEATHER_DATA = "data/2.5/weather?appid=51c1e50201cd928ee2882703388464d3"
const val FETCH_WEATHER_FOR_5_DAYS_EVERY_THREE_HOURS = "data/2.5/forecast?appid=51c1e50201cd928ee2882703388464d3"

interface WeatherService {

    @GET(FETCH_CURRENT_WEATHER_DATA)
    suspend fun fetchCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
    ): Response<CurrentWeatherResponseCloud>

    @GET(FETCH_WEATHER_FOR_5_DAYS_EVERY_THREE_HOURS)
    suspend fun fetchWeatherForFiveDays(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
    ): Response<WeatherForFiveDaysResponseCloud>
}