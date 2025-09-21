package com.tamarcusg.openweather.forecast

import com.tamarcusg.openweather.repository.model.Forecast

internal data class ForecastUIState(
    val forecasts: List<Forecast> = emptyList(),
    val isBottomSheetVisible: Boolean = false,
    val selectedForecast: Forecast? = null
)