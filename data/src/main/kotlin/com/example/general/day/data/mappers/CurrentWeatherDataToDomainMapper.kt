package com.example.general.day.data.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.data.models.CurrentWeatherData
import com.example.general.day.domain.models.CurrentWeatherDomain
import javax.inject.Inject

class CurrentWeatherDataToDomainMapper @Inject constructor(
    private val coordinatesDataToDomain: CoordinatesDataToDomainMapper,
    private val cloudsDataToCloudsDomain: CloudsDataToDomainMapper,
    private val weatherTemperatureDataToDomain: WeatherTemperatureDataToDomainMapper,
    private val weatherSystemInformationDataToDomain: WeatherSystemInformationDataToDomainMapper,
    private val weatherDataToWeatherDomain: WeatherDataToDomainMapper,
    private val windDataToWindDomain: WindDataToDomainMapper,
) : Mapper<CurrentWeatherData, CurrentWeatherDomain> {

    override fun map(from: CurrentWeatherData): CurrentWeatherDomain = from.run {
        CurrentWeatherDomain(
            base = base,
            clouds = cloudsDataToCloudsDomain.map(clouds),
            cod = cod,
            coordinates = coordinatesDataToDomain.map(coordinates),
            time = time,
            id = id,
            weatherTemperature = weatherTemperatureDataToDomain.map(
                weatherTemperature
            ),
            name = name,
            systemInformation = weatherSystemInformationDataToDomain.map(
                systemInformation
            ),
            weather = weather.map(weatherDataToWeatherDomain::map),
            wind = windDataToWindDomain.map(wind)
        )
    }
}