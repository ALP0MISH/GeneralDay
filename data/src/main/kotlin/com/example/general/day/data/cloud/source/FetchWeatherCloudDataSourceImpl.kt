package com.example.general.day.data.cloud.source

import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponseCloud
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
    ): CurrentWeatherResponseCloud {
        return try {
            val response = service.fetchCurrentWeather(latitude, longitude)
            if (response.isSuccessful) {
                response.body() ?: CurrentWeatherResponseCloud.unknown
            } else {
                CurrentWeatherResponseCloud.unknown
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            CurrentWeatherResponseCloud.unknown
        }
    }


    override suspend fun fetchWeatherForFiveDays(
        latitude: Double,
        longitude: Double
    ): WeatherForFiveDaysResponseCloud {
        return try {
            val response = service.fetchWeatherForFiveDays(latitude, longitude)
            if (response.isSuccessful) {
                response.body() ?: WeatherForFiveDaysResponseCloud.unknown
            } else {
                WeatherForFiveDaysResponseCloud.unknown
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            WeatherForFiveDaysResponseCloud.unknown
        }
    }

    override suspend fun fetchCurrentCityWeather(cityName: String): CurrentWeatherResponseCloud {
        return try {
            val response = serviceCity.fetchCurrentCityWeather(cityName)
            if (response.isSuccessful) {
                response.body() ?: CurrentWeatherResponseCloud.unknown
            } else {
                CurrentWeatherResponseCloud.unknown
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            CurrentWeatherResponseCloud.unknown
        }
    }

    override suspend fun fetchWeatherCityForFiveDays(cityName: String): WeatherForFiveDaysResponseCloud {
        return try {
            val response = serviceCity.fetchWeatherCityWeatherForFiveDays(cityName)
            if (response.isSuccessful) {
                response.body() ?: WeatherForFiveDaysResponseCloud.unknown
            } else {
                WeatherForFiveDaysResponseCloud.unknown
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            WeatherForFiveDaysResponseCloud.unknown
        }
    }
}