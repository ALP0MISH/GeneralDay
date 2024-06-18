package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CurrentWeatherResponseCloud
import com.example.general.day.data.models.CurrentWeatherData
import javax.inject.Inject

 class CurrentWeatherCloudToCurrentWeatherDataMapper @Inject constructor(
    private val coordinatesLocalToCoordinatesDomain: CoordinatesCloudToCoordinatesDataMapper,
    private val cloudsCloudToCloudsDomain: CloudsCloudToCloudsDataMapper,
    private val weatherTemperatureCloudToWeatherTemperatureDomain: WeatherTemperatureCloudToWeatherTemperatureDataMapper,
    private val weatherSystemInformationCloudToWeatherSystemInformationDomain: WeatherSystemInformationCloudToWeatherSystemInformationDataMapper,
    private val weatherCloudToWeatherDomain: WeatherCloudToWeatherDataMapper,
    private val windCloudToWindDomain: WindCloudToWindDataMapper,
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