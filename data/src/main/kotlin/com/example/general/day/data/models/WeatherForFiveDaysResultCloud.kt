package com.example.general.day.data.models

import com.example.general.day.data.local.models.LocalClouds
import com.example.general.day.data.local.models.LocalRainAndSnow
import com.example.general.day.data.local.models.LocalSys
import com.example.general.day.data.local.models.LocalWeather
import com.example.general.day.data.local.models.LocalWeatherForFiveDaysResultCloud
import com.example.general.day.data.local.models.LocalWind

data class WeatherForFiveDaysResultCloud(
    val localClouds: LocalClouds,
    val dt: Int,
    val dtTxt: String,
    val localMain: LocalMain,
    val pop: Double,
    val localRainAndSnow: LocalRainAndSnow,
    val snow: LocalRainAndSnow,
    val localSys: LocalSys,
    val visibility: Int,
    val localWeather: List<LocalWeather>,
    val localWind: LocalWind
) {
    companion object {
        val unknown = LocalWeatherForFiveDaysResultCloud(
            localClouds = LocalClouds(all = -1),
            dt = -1,
            dtTxt = String(),
            localMain = Main.unknown,
            pop = 0.0,
            localRainAndSnow = LocalRainAndSnow(h = 0.0),
            snow = LocalRainAndSnow(h = 0.0),
            localSys = LocalSys(pod = String()),
            visibility = -1,
            localWeather = emptyList(),
            localWind = LocalWind(deg = -1, speed = 0.0)
        )
    }
}