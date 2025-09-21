package com.tamarcusg.openweather.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tamarcusg.openweather.forecast.ForecastContent
import com.tamarcusg.openweather.forecast.ForecastViewModel
import kotlinx.serialization.Serializable

@Serializable
internal data object ForecastContentRoute

internal fun NavGraphBuilder.forecastContentRoute() {
    composable<ForecastContentRoute> {
        val viewModel: ForecastViewModel = hiltViewModel()
        val uiState = viewModel.state.collectAsStateWithLifecycle().value
        ForecastContent(
            uiState = uiState,
            onHandleEvent = viewModel::handleEvent
        )
    }
}