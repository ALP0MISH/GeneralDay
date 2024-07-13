package com.example.general.day.data.cloud.service

import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.cloud.models.SearchWeatherCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponseCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val GET_CITY_WEATHER = "&appid=51c1e50201cd928ee2882703388464d3"
private const val SEARCH_CITY_WEATHER = "&limit=5&appid=51c1e50201cd928ee2882703388464d3"

interface CityWeatherService {

    @GET(GET_CITY_WEATHER)
    suspend fun fetchCurrentCityWeather(
        @Query("data/2.5/weather?q=") cityName: String,
    ): Response<CurrentWeatherResponseCloud>

    @GET(GET_CITY_WEATHER)
    suspend fun fetchWeatherCityWeatherForFiveDays(
        @Query("data/2.5/forecast?q=") cityName: String,
    ): Response<WeatherForFiveDaysResponseCloud>

    @GET(SEARCH_CITY_WEATHER)
    suspend fun fetchSearchWeatherCity(
        @Query("geo/1.0/direct?q=") cityName: String,
    ): Response<List<SearchWeatherCloud>>
}