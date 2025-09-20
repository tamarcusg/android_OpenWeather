package com.tamarcusg.openweather.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
internal object NavigationGraph

internal fun NavGraphBuilder.navigationGraph() {
    navigation<NavigationGraph>(
        startDestination = HomeScreenRoute
    ) {
        homeScreenRoute()
    }
}