package com.tamarcusg.openweather.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tamarcusg.openweather.forecast.ForecastUIEvent
import com.tamarcusg.openweather.forecast.ForecastViewModel
import com.tamarcusg.openweather.home.HomeContent
import com.tamarcusg.openweather.home.HomeViewModel
import kotlinx.serialization.Serializable

@Serializable
internal data object HomeScreenRoute

internal fun NavGraphBuilder.homeContentRoute(
    navController: NavController
) {
    composable<HomeScreenRoute> {
        val homeViewModel: HomeViewModel = hiltViewModel()
        val homeUiState = homeViewModel.state.collectAsStateWithLifecycle().value
        val forecastViewModel: ForecastViewModel = hiltViewModel()
        HomeContent(
            uiState = homeUiState,
            onHandleEvent = homeViewModel::handleEvent,
            onForecastLoaded = { forecastList ->
                forecastViewModel.handleEvent(
                    ForecastUIEvent.PopulateForecastList(forecastList)
                )
                navController.navigate(ForecastContentRoute)
            }
        )
    }
}