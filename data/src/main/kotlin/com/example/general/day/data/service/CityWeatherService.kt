package com.example.general.day.data.service

import com.example.general.day.data.model.current.weather.CurrentWeatherResponse
import com.example.general.day.data.model.weather.five.days.WeatherForFiveDaysResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val GET_CITY_WEATHER = "&appid=51c1e50201cd928ee2882703388464d3"

interface CityWeatherService {

    @GET(GET_CITY_WEATHER)
    suspend fun getCurrentWeather(
        @Query("data/2.5/weather?q=") cityName: String,
    ): Response<CurrentWeatherResponse>

    @GET(GET_CITY_WEATHER)
    suspend fun getWeatherForFiveDays(
        @Query("data/2.5/forecast?q=") cityName: String,
    ): Response<WeatherForFiveDaysResponse>
}