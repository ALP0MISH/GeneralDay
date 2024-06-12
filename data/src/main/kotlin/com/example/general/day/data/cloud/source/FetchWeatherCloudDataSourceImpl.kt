package com.example.general.day.data.cloud.source

import com.example.general.day.core.dispatchers.CoroutineDispatchers
import com.example.general.day.core.extantions.callSafe
import com.example.general.day.data.cloud.mapper.CurrentWeatherCloudToDataMapper
import com.example.general.day.data.cloud.mapper.WeatherForFiveDaysResponseCloudToDataMapper
import com.example.general.day.data.cloud.service.CityWeatherService
import com.example.general.day.data.cloud.service.WeatherService
import com.example.general.day.data.models.CurrentWeatherData
import com.example.general.day.data.models.WeatherForFiveDaysData
import javax.inject.Inject

class FetchWeatherCloudDataSourceImpl @Inject constructor(
    private val serviceCity: CityWeatherService,
    private val service: WeatherService,
    private val coroutineDispatchers: CoroutineDispatchers,
    private val currentWeatherCloudToDataMapper: CurrentWeatherCloudToDataMapper,
    private val weatherForFiveDaysToDataMapper: WeatherForFiveDaysResponseCloudToDataMapper,
) : FetchWeatherCloudDataSource {

    override suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double
    ): CurrentWeatherData =
        callSafe(coroutineDispatchers.io) {
            val response = service.fetchCurrentWeather(latitude, longitude)
            if (response.isSuccessful) {
                response.body()?.let { currentWeatherCloudToDataMapper.map(it) }
                    ?: CurrentWeatherData.unknown
            } else {
                CurrentWeatherData.unknown
            }
        }

    override suspend fun fetchWeatherForFiveDays(
        latitude: Double,
        longitude: Double
    ): WeatherForFiveDaysData =
        callSafe(coroutineDispatchers.io) {
            val response = service.fetchWeatherForFiveDays(latitude, longitude)
            if (response.isSuccessful) {
                response.body()
                    ?.let { weatherForFiveDaysToDataMapper.map(it) }
                    ?: WeatherForFiveDaysData.unknown
            } else {
                WeatherForFiveDaysData.unknown
            }
        }

    override suspend fun fetchCurrentCityWeather(cityName: String): CurrentWeatherData =
        callSafe(coroutineDispatchers.io) {
            val response = serviceCity.fetchCurrentCityWeather(cityName)
            if (response.isSuccessful) {
                response.body()?.let {
                    currentWeatherCloudToDataMapper.map(it)
                } ?: CurrentWeatherData.unknown
            } else {
                CurrentWeatherData.unknown
            }
        }

    override suspend fun fetchWeatherCityForFiveDays(cityName: String): WeatherForFiveDaysData =
        callSafe(coroutineDispatchers.io) {
            val response = serviceCity.fetchWeatherCityWeatherForFiveDays(cityName)
            if (response.isSuccessful) {
                response.body()?.let {
                    weatherForFiveDaysToDataMapper.map(it)
                } ?: WeatherForFiveDaysData.unknown
            } else {
                WeatherForFiveDaysData.unknown
            }
        }
}