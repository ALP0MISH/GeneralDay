package com.example.general.day.favorite.api

import com.example.general.day.core.FeatureApi

interface FavoriteFeatureUIApi : FeatureApi {

    val favoriteRouteProvider: FavoriteRouteProvider
}