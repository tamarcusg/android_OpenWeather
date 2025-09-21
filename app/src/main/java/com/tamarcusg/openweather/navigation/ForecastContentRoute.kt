package com.tamarcusg.openweather.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.tamarcusg.openweather.forecast.ForecastContent
import com.tamarcusg.openweather.forecast.ForecastViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.Serializable

@Serializable
internal data class ForecastContentRoute(
    val topBarTitle: String
)

internal fun NavGraphBuilder.forecastContentRoute(
    navController: NavController,
    mutableTopAppBarUIState: MutableStateFlow<TopAppBarUIState>
) {
    composable<ForecastContentRoute> { backStackEntry ->
        val args = backStackEntry.toRoute<ForecastContentRoute>()

        val viewModel: ForecastViewModel = hiltViewModel()
        val uiState = viewModel.state.collectAsStateWithLifecycle().value

        mutableTopAppBarUIState.update {
            it.copy(
                title = args.topBarTitle,
                isVisible = true,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        ForecastContent(
            uiState = uiState,
            onHandleEvent = viewModel::handleEvent
        )
    }
}