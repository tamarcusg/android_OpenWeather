package com.tamarcusg.openweather.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tamarcusg.openweather.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
internal object HomeScreenRoute

internal fun NavGraphBuilder.homeScreenRoute() {
    composable<HomeScreenRoute> {
        HomeScreen()
    }
}