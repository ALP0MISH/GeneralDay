package com.example.general.day.home.api

import com.example.general.day.core.FeatureApi

interface HomeFeatureUiApi : FeatureApi {

    val homeRouteProvider: HomeRouteProvider
}