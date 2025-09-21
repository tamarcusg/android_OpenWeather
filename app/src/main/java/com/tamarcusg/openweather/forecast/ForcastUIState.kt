package com.tamarcusg.openweather.forecast

import com.tamarcusg.openweather.repository.model.Forecast

internal data class ForecastUIState(
    val forecasts: List<Forecast> = emptyList(),
    val selectedForecast: Forecast? = null
)