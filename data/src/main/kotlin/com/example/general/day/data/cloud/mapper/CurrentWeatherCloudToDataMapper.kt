package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.models.CurrentWeatherData
import javax.inject.Inject

 class CurrentWeatherCloudToDataMapper @Inject constructor(
     private val coordinatesLocalToDomain: CoordinatesCloudToDataMapper,
     private val cloudsCloudToCloudsDomain: CloudsCloudToDataMapper,
     private val weatherTemperatureCloudToDomain: WeatherTemperatureCloudToDataMapper,
     private val weatherSystemInformationCloudToDomain: WeatherSystemInformationCloudToDataMapper,
     private val weatherCloudToDomain: WeatherCloudToDataMapper,
     private val windCloudToWindDomain: WindCloudToDataMapper,
) : Mapper<CurrentWeatherResponseCloud, CurrentWeatherData> {
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