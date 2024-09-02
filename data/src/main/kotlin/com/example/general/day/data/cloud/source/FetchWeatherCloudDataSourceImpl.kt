package com.example.general.day.data.cloud.source

import com.example.general.day.core.Mapper
import com.example.general.day.core.R.string
import com.example.general.day.core.ToastNotificationManger
import com.example.general.day.core.dispatchers.CoroutineDispatchers
import com.example.general.day.core.extantions.callSafe
import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.cloud.models.SearchWeatherCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponseCloud
import com.example.general.day.data.cloud.service.CityWeatherService
import com.example.general.day.data.cloud.service.WeatherService
import com.example.general.day.data.models.CurrentWeatherData
import com.example.general.day.data.models.SearchWeatherData
import com.example.general.day.data.models.WeatherForFiveDaysData
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val Letter_A = 'А'
private const val Letter_EA = 'я'
private const val Letter_E = 'Ё'
private const val Letter_e = 'ё'
private const val RU = "ru"
private const val EN = "en"

class FetchWeatherCloudDataSourceImpl @Inject constructor(
    private val serviceCity: CityWeatherService,
    private val service: WeatherService,
    private val coroutineDispatchers: CoroutineDispatchers,
    private val currentWeatherCloudToDataMapper: @JvmSuppressWildcards Mapper<CurrentWeatherResponseCloud, CurrentWeatherData>,
    private val weatherForFiveDaysToDataMapper: @JvmSuppressWildcards Mapper<WeatherForFiveDaysResponseCloud, WeatherForFiveDaysData>,
    private val searchWeatherCloudToDataMapper: @JvmSuppressWildcards Mapper<SearchWeatherCloud, SearchWeatherData>,
    private val toastNotificationManger: ToastNotificationManger
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
            val lang =
                if (cityName.any { it in Letter_A..Letter_EA || it in Letter_E..Letter_e }) RU else EN
            val response = serviceCity.fetchCurrentCityWeather(cityName = cityName, lang = lang)
            if (response.isSuccessful && response.body() != null) {
                response.body()?.let {
                    currentWeatherCloudToDataMapper.map(it)
                } ?: CurrentWeatherData.unknown
            } else {
                CurrentWeatherData.unknown
            }
        }

    override suspend fun fetchWeatherCityForFiveDays(cityName: String): WeatherForFiveDaysData =
        callSafe(coroutineDispatchers.io) {
            val lang =
                if (cityName.any { it in Letter_A..Letter_EA || it in Letter_E..Letter_e }) RU else EN
            val response =
                serviceCity.fetchWeatherCityWeatherForFiveDays(cityName = cityName, lang = lang)
            if (response.isSuccessful && response.body() != null) {
                response.body()?.let {
                    weatherForFiveDaysToDataMapper.map(it)
                } ?: WeatherForFiveDaysData.unknown
            } else {
                withContext(coroutineDispatchers.main) {
                    toastNotificationManger.showToast(string.error_message)
                }
                WeatherForFiveDaysData.unknown
            }
        }

    override suspend fun fetchSearchWeatherCity(cityName: String): List<SearchWeatherData> =
        callSafe(coroutineDispatchers.io) {
            val response = serviceCity.fetchSearchWeatherCity(cityName)
            if (response.isSuccessful) {
                response.body()?.map(searchWeatherCloudToDataMapper::map) ?: emptyList()
            } else {
                emptyList()
            }
        }
}