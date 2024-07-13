package com.example.general.day.data.cloud.mapper

import com.example.general.day.core.Mapper
import com.example.general.day.data.cloud.models.SearchWeatherCloud
import com.example.general.day.data.models.SearchWeatherData
import javax.inject.Inject

class SearchWeatherCloudToDataMapper @Inject constructor(
) : Mapper<SearchWeatherCloud, SearchWeatherData> {
    override fun map(from: SearchWeatherCloud): SearchWeatherData = from.run {
        SearchWeatherData(
            country = country,
            lat = lat,
            lon = lon,
            name = name,
            state = state,
        )
    }
}