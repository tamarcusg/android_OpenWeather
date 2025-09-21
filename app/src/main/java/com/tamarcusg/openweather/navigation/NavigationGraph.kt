package com.tamarcusg.openweather.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.Serializable

@Serializable
internal object NavigationGraph

internal fun NavGraphBuilder.navigationGraph(
    navController: NavController,
    mutableTopAppBarUIState: MutableStateFlow<TopAppBarUIState>
) {
    navigation<NavigationGraph>(
        startDestination = HomeScreenRoute
    ) {

        homeContentRoute(
            navController = navController,
            mutableTopAppBarUIState = mutableTopAppBarUIState,
        )

        forecastContentRoute(
            navController = navController,
            mutableTopAppBarUIState = mutableTopAppBarUIState,
        )
    }
}