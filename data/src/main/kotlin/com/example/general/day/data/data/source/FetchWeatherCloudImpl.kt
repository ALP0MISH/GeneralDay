package com.example.general.day.data.data.source

import com.example.general.day.data.model.current.weather.CurrentWeatherResponse
import com.example.general.day.data.model.weather.five.days.WeatherForFiveDaysResponse
import com.example.general.day.data.service.CityWeatherService
import com.example.general.day.data.service.WeatherService
import java.util.concurrent.CancellationException
import javax.inject.Inject

class FetchWeatherCloudImpl @Inject constructor(
    private val serviceCity: CityWeatherService,
    private val service: WeatherService
) : FetchWeatherCloud {

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