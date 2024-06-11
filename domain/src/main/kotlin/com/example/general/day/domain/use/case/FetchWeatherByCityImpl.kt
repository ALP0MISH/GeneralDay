package com.example.general.day.domain.use.case

import com.example.general.day.domain.models.CurrentWeatherDomain
import com.example.general.day.domain.models.WeatherForFiveDaysDomain

class FetchWeatherByCityImpl:FetchWeatherByCity {
    override suspend fun fetchCurrentCityWeather(cityName: String): CurrentWeatherDomain {
        TODO("Not yet implemented")
    }

    override suspend fun fetchWeatherCityForFiveDays(cityName: String): WeatherForFiveDaysDomain {
        TODO("Not yet implemented")
    }
}