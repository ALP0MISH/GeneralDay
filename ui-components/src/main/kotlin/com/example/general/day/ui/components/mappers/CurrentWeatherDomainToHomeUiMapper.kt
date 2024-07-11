package com.example.general.day.ui.components.mappers

import com.example.general.day.core.Mapper
import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.ui.components.models.CurrentWeatherHomeUi
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

class CurrentWeatherDomainToHomeUiMapper @Inject constructor(
    private val coordinatesDomainToHomeUi: CoordinatesDomainToHomeUiMapper,
    private val cloudsDomainToCloudsHomeUi: CloudsDomainToHomeUiMapper,
    private val weatherTemperatureDomainToHomeUi: WeatherTemperatureDomainToHomeUiMapper,
    private val weatherSystemInformationDomainToHomeUi: WeatherSystemInformationDomainToHomeUiMapper,
    private val weatherDomainToWeatherHomeUI: WeatherDomainToHomeUiMapper,
    private val windDomainToWindHomeUi: WindDomainToHomeUIMapper,
) : Mapper<CurrentWeatherDomain, CurrentWeatherHomeUi> {

    override fun map(from: CurrentWeatherDomain): CurrentWeatherHomeUi = from.run {
        CurrentWeatherHomeUi(
            base = base,
            clouds = cloudsDomainToCloudsHomeUi.map(clouds),
            cod = cod,
            coordinates = coordinatesDomainToHomeUi.map(coordinates),
            time = time,
            id = id,
            weatherTemperature = weatherTemperatureDomainToHomeUi.map(
                weatherTemperature
            ),
            name = name,
            systemInformation = weatherSystemInformationDomainToHomeUi.map(systemInformation),
            weather = weather.map(weatherDomainToWeatherHomeUI::map).toImmutableList(),
            wind = windDomainToWindHomeUi.map(wind)
        )
    }
}