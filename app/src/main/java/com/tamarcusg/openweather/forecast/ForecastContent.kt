package com.tamarcusg.openweather.forecast

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.tamarcusg.openweather.forecast.details.ForecastDetailsContent
import com.tamarcusg.openweather.preview.ForecastListPreviewProvider
import com.tamarcusg.openweather.preview.OpenWeatherPreview
import com.tamarcusg.openweather.repository.model.Forecast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ForecastContent(
    modifier: Modifier = Modifier,
    uiState: ForecastUIState,
    onHandleEvent: (ForecastUIEvent) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(uiState.forecasts.size) { index ->
                val forecast = uiState.forecasts[index]
                ForecastRow(
                    modifier = Modifier.padding(vertical = 8.dp),
                    forecast = forecast,
                    onClick = {
                        onHandleEvent(ForecastUIEvent.ForecastClicked(forecast))
                    }
                )
                if (index < uiState.forecasts.lastIndex) {
                    HorizontalDivider()
                }
            }
        }

        if (uiState.selectedForecast != null) {
            ModalBottomSheet(
                onDismissRequest = {
                    onHandleEvent(ForecastUIEvent.DismissBottomSheet)
                },
                sheetState = SheetState(
                    skipPartiallyExpanded = true,
                    density = LocalDensity.current
                ),
                dragHandle = null,
                shape = RectangleShape
            ) {
                ForecastDetailsContent(
                    forecast = uiState.selectedForecast,
                    onCloseClick = {
                        onHandleEvent(ForecastUIEvent.DismissBottomSheet)
                    }
                )
            }
        }

    }
}

@OpenWeatherPreview
@Composable
private fun ForecastContentPreview(
    @PreviewParameter(ForecastListPreviewProvider::class) forecastList: List<Forecast>
) {
    ForecastContent(
        uiState = ForecastUIState(
            forecasts = forecastList
        ),
        onHandleEvent = {}
    )
}