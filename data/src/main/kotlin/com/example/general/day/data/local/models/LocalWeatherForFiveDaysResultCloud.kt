package com.example.general.day.data.local.models

import com.example.general.day.data.models.LocalMain
import com.example.general.day.data.models.Main
import com.example.general.day.data.models.WeatherForFiveDaysResultCloud

data class LocalWeatherForFiveDaysResultCloud(
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
        val unknown = WeatherForFiveDaysResultCloud(
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