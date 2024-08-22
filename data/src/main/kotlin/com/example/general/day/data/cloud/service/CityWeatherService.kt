package com.example.general.day.data.cloud.service

import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.cloud.models.SearchWeatherCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponseCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "51c1e50201cd928ee2882703388464d3"

interface CityWeatherService {

    @GET("data/2.5/weather")
    suspend fun fetchCurrentCityWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String = API_KEY,
        @Query("lang") lang: String,
    ): Response<CurrentWeatherResponseCloud>

    @GET("data/2.5/forecast")
    suspend fun fetchWeatherCityWeatherForFiveDays(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String = API_KEY,
        @Query("lang") lang: String,
    ): Response<WeatherForFiveDaysResponseCloud>

    @GET("geo/1.0/direct")
    suspend fun fetchSearchWeatherCity(
        @Query("q") cityName: String,
        @Query("limit") limit: Int = 5,
        @Query("appid") apiKey: String = API_KEY,
    ): Response<List<SearchWeatherCloud>>
}