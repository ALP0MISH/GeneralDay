package com.example.general.day.data.cloud.source

import com.example.general.day.data.cloud.models.CurrentWeatherResponse
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponse
import com.example.general.day.data.cloud.service.CityWeatherService
import com.example.general.day.data.cloud.service.WeatherService
import java.util.concurrent.CancellationException
import javax.inject.Inject

class FetchWeatherCloudDataSourceImpl @Inject constructor(
    private val serviceCity: CityWeatherService,
    private val service: WeatherService
) : FetchWeatherCloudDataSource {

    override suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double
    ): CurrentWeatherResponse {
        return try {
            val response = service.fetchCurrentWeather(latitude, longitude)
            if (response.isSuccessful) {
                response.body() ?: CurrentWeatherResponse.unknown
            } else {
                CurrentWeatherResponse.unknown
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            CurrentWeatherResponse.unknown
        }
    }

    override suspend fun fetchWeatherForFiveDays(
        latitude: Double,
        longitude: Double
    ): WeatherForFiveDaysResponse {
        return try {
            val response = service.fetchWeatherForFiveDays(latitude, longitude)
            if (response.isSuccessful) {
                response.body() ?: WeatherForFiveDaysResponse.unknown
            } else {
                WeatherForFiveDaysResponse.unknown
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            WeatherForFiveDaysResponse.unknown
        }
    }

    override suspend fun fetchCurrentCityWeather(cityName: String): CurrentWeatherResponse {
        return try {
            val response = serviceCity.fetchCurrentCityWeather(cityName)
            if (response.isSuccessful) {
                response.body() ?: CurrentWeatherResponse.unknown
            } else {
                CurrentWeatherResponse.unknown
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            CurrentWeatherResponse.unknown
        }
    }

    override suspend fun fetchWeatherCityForFiveDays(cityName: String): WeatherForFiveDaysResponse {
        return try {
            val response = serviceCity.fetchWeatherCityWeatherForFiveDays(cityName)
            if (response.isSuccessful) {
                response.body() ?: WeatherForFiveDaysResponse.unknown
            } else {
                WeatherForFiveDaysResponse.unknown
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            WeatherForFiveDaysResponse.unknown
        }
    }
}