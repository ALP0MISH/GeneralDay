package com.example.general.day.data.cloud.service

import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponseCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val GET_CITY_WEATHER = "&appid=51c1e50201cd928ee2882703388464d3"
interface CityWeatherService {

    @GET(GET_CITY_WEATHER)
    suspend fun fetchCurrentCityWeather(
        @Query("data/2.5/weather?q=") cityName: String,
    ): Response<CurrentWeatherResponseCloud>

    @GET(GET_CITY_WEATHER)
    suspend fun fetchWeatherCityWeatherForFiveDays(
        @Query("data/2.5/forecast?q=") cityName: String,
    ): Response<WeatherForFiveDaysResponseCloud>
}