package com.tamarcusg.openweather.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tamarcusg.openweather.home.HomeContent
import com.tamarcusg.openweather.home.HomeViewModel
import kotlinx.serialization.Serializable

@Serializable
internal object HomeScreenRoute

internal fun NavGraphBuilder.homeScreenRoute(
    navController: NavController
) {
    composable<HomeScreenRoute> {
        val viewModel: HomeViewModel = hiltViewModel()
        val uiState = viewModel.state.collectAsStateWithLifecycle().value
        HomeContent(
            uiState = uiState,
            onHandleEvent = viewModel::handleEvent,
            navController = navController
        )
    }
}