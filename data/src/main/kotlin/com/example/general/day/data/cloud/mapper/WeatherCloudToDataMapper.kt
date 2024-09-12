package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.WeatherCloud
import com.example.general.day.data.models.WeatherData
import javax.inject.Inject

class WeatherCloudToDataMapper @Inject constructor() :
    Mapper<@JvmSuppressWildcards WeatherCloud, @JvmSuppressWildcards WeatherData> {
    override fun map(from: WeatherCloud): WeatherData = from.run {
        WeatherData(
            description = description,
            icon = icon,
            id = id,
            main = main,
        )
    }
}