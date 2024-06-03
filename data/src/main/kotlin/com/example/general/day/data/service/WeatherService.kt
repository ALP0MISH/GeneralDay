package com.example.general.day.data.service

import com.example.general.day.data.model.current.weather.CurrentWeatherResponse
import com.example.general.day.data.model.weather.five.days.WeatherForFiveDaysResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val GET_CURRENT_WEATHER_DATA = "data/2.5/weather?appid=51c1e50201cd928ee2882703388464d3"
const val GET_WEATHER_FOR_5_DAYS_EVERY_THREE_HOURS = "data/2.5/forecast?appid=51c1e50201cd928ee2882703388464d3"

interface WeatherService {

    @GET(GET_CURRENT_WEATHER_DATA)
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
    ): Response<CurrentWeatherResponse>

    @GET(GET_WEATHER_FOR_5_DAYS_EVERY_THREE_HOURS)
    suspend fun getWeatherForFiveDays(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
    ): Response<WeatherForFiveDaysResponse>
}