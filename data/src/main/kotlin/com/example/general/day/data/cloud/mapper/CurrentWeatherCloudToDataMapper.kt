package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.models.CurrentWeatherData
import javax.inject.Inject

 class CurrentWeatherCloudToDataMapper @Inject constructor(
     private val coordinatesLocalToCoordinatesDomain: CoordinatesCloudToDataMapper,
     private val cloudsCloudToCloudsDomain: CloudsCloudToDataMapper,
     private val weatherTemperatureCloudToWeatherTemperatureDomain: WeatherTemperatureCloudToDataMapper,
     private val weatherSystemInformationCloudToWeatherSystemInformationDomain: WeatherSystemInformationCloudToDataMapper,
     private val weatherCloudToWeatherDomain: WeatherCloudToDataMapper,
     private val windCloudToWindDomain: WindCloudToDataMapper,
) : Mapper<CurrentWeatherResponseCloud, CurrentWeatherData> {
    override fun map(from: CurrentWeatherResponseCloud): CurrentWeatherData = from.run {
        CurrentWeatherData(
            base = base,
            clouds = cloudsCloudToCloudsDomain.map(clouds),
            cod = code,
            coordinates = coordinatesLocalToCoordinatesDomain.map(coordinates),
            time = time,
            id = id,
            weatherTemperature = weatherTemperatureCloudToWeatherTemperatureDomain.map(
                weatherTemperature
            ),
            name = name,
            systemInformation = weatherSystemInformationCloudToWeatherSystemInformationDomain.map(
                systemInformation
            ),
            weather = weather.map(weatherCloudToWeatherDomain::map),
            wind = windCloudToWindDomain.map(wind)
        )
    }
}