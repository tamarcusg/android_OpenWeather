package com.tamarcusg.openweather.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
internal object NavigationGraph

internal fun NavGraphBuilder.navigationGraph(
    navController: NavController
) {
    navigation<NavigationGraph>(
        startDestination = HomeScreenRoute
    ) {

        homeScreenRoute(
            navController = navController
        )
    }
}