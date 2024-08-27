package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CloudsCloud
import com.example.general.day.data.cloud.models.CoordinatesCloud
import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.cloud.models.WeatherCloud
import com.example.general.day.data.cloud.models.WeatherSystemInformationCloud
import com.example.general.day.data.cloud.models.WeatherTemperatureCloud
import com.example.general.day.data.cloud.models.WindCloud
import com.example.general.day.data.models.CloudsData
import com.example.general.day.data.models.CoordinatesData
import com.example.general.day.data.models.CurrentWeatherData
import com.example.general.day.data.models.WeatherData
import com.example.general.day.data.models.WeatherSystemInformationData
import com.example.general.day.data.models.WeatherTemperatureData
import com.example.general.day.data.models.WindData
import javax.inject.Inject

class CurrentWeatherCloudToDataMapper @Inject constructor(
    private val coordinatesLocalToDomain: @JvmSuppressWildcards Mapper<CoordinatesCloud, CoordinatesData>,
    private val cloudsCloudToCloudsDomain: @JvmSuppressWildcards Mapper<CloudsCloud, CloudsData>,
    private val weatherTemperatureCloudToDomain: @JvmSuppressWildcards Mapper<WeatherTemperatureCloud, WeatherTemperatureData>,
    private val weatherSystemInformationCloudToDomain: @JvmSuppressWildcards Mapper<WeatherSystemInformationCloud, WeatherSystemInformationData>,
    private val weatherCloudToDomain: @JvmSuppressWildcards Mapper<WeatherCloud, WeatherData>,
    private val windCloudToWindDomain: @JvmSuppressWildcards Mapper<WindCloud, WindData>,
) : Mapper<@JvmSuppressWildcards CurrentWeatherResponseCloud, @JvmSuppressWildcards CurrentWeatherData> {
    override fun map(from: CurrentWeatherResponseCloud): CurrentWeatherData = from.run {
        CurrentWeatherData(
            base = base,
            clouds = cloudsCloudToCloudsDomain.map(clouds),
            cod = code,
            coordinates = coordinatesLocalToDomain.map(coordinates),
            time = time,
            id = id,
            weatherTemperature = weatherTemperatureCloudToDomain.map(
                weatherTemperature
            ),
            name = name,
            systemInformation = weatherSystemInformationCloudToDomain.map(
                systemInformation
            ),
            weather = weather.map(weatherCloudToDomain::map),
            wind = windCloudToWindDomain.map(wind)
        )
    }
}