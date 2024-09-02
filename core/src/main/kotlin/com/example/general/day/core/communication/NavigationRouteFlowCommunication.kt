package com.example.general.day.core.communication

import androidx.navigation.NavOptionsBuilder
import javax.inject.Singleton

typealias ActionAfterNavigate = NavOptionsBuilder.() -> Unit

fun navigationParams(route: String): NavigationParams = NavigationParams(route) {}

fun navigationParams(
    route: String,
    actionAfterNavigate: ActionAfterNavigate
): NavigationParams = NavigationParams(route, actionAfterNavigate)

data class NavigationParams(
    val route: String,
    val actionAfterNavigate: ActionAfterNavigate,
)

interface NavigationRouteFlowCommunication : SharedFlowCommunication<NavigationParams> {

    @Singleton
    class Default : SingleLiveEventFlowCommunicationImpl<NavigationParams>(),
        NavigationRouteFlowCommunication
}