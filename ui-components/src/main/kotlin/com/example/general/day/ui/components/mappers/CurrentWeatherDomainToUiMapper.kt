package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.ui.components.models.CurrentWeatherUi
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

class CurrentWeatherDomainToUiMapper @Inject constructor(
    private val coordinatesDomainToUi: CoordinatesDomainToUiMapper,
    private val cloudsDomainToCloudsUi: CloudsDomainToUiMapper,
    private val weatherTemperatureDomainToUi: WeatherTemperatureDomainToUiMapper,
    private val weatherSystemInformationDomainToUi: WeatherSystemInformationDomainToUiMapper,
    private val weatherDomainToWeatherUI: WeatherDomainToUiMapper,
    private val windDomainToWindUi: WindDomainToUIMapper,
) : Mapper<CurrentWeatherDomain, CurrentWeatherUi> {

    override fun map(from: CurrentWeatherDomain): CurrentWeatherUi = from.run {
        CurrentWeatherUi(
            base = base,
            clouds = cloudsDomainToCloudsUi.map(clouds),
            cod = cod,
            coordinates = coordinatesDomainToUi.map(coordinates),
            time = time,
            id = id,
            weatherTemperature = weatherTemperatureDomainToUi.map(
                weatherTemperature
            ),
            name = name,
            systemInformation = weatherSystemInformationDomainToUi.map(systemInformation),
            weather = weather.map(weatherDomainToWeatherUI::map).toImmutableList(),
            wind = windDomainToWindUi.map(wind)
        )
    }
}