package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.CityCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResponseCloud
import com.example.general.day.data.cloud.models.WeatherForFiveDaysResultCloud
import com.example.general.day.data.models.CityData
import com.example.general.day.data.models.WeatherForFiveDaysData
import com.example.general.day.data.models.WeatherForFiveDaysResultData
import javax.inject.Inject

class WeatherForFiveDaysResponseCloudToDataMapper @Inject constructor(
    private val cityCloudToCityDomain: @JvmSuppressWildcards Mapper<CityCloud, CityData>,
    private val weatherForFiveDaysResultCloudToDomain: @JvmSuppressWildcards Mapper<WeatherForFiveDaysResultCloud, WeatherForFiveDaysResultData>,
) : Mapper<@JvmSuppressWildcards WeatherForFiveDaysResponseCloud, @JvmSuppressWildcards WeatherForFiveDaysData> {
    override fun map(from: WeatherForFiveDaysResponseCloud): WeatherForFiveDaysData = from.run {
        WeatherForFiveDaysData(
            city = cityCloudToCityDomain.map(city),
            timeCount = timeCount,
            code = code,
            list = list.map(weatherForFiveDaysResultCloudToDomain::map),
            message = message
        )
    }
}