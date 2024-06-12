package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponseCloud
import com.example.general.day.data.models.WeatherForFiveDaysData
import javax.inject.Inject

class WeatherForFiveDaysResponseCloudToDataMapper @Inject constructor(
    private val cityCloudToCityDomain: CityCloudToDataMapper,
    private val weatherForFiveDaysResultCloudToWeatherForFiveDaysDomain: WeatherForFiveDaysResultCloudToDataMapper,
) : Mapper<WeatherForFiveDaysResponseCloud, WeatherForFiveDaysData> {
    override fun map(from: WeatherForFiveDaysResponseCloud): WeatherForFiveDaysData = from.run {
        WeatherForFiveDaysData(
            city = cityCloudToCityDomain.map(city),
            timeCount = timeCount,
            code = code,
            list = list.map(weatherForFiveDaysResultCloudToWeatherForFiveDaysDomain::map),
            message = message
        )
    }
}