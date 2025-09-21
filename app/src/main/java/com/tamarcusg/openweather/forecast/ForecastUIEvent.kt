package com.tamarcusg.openweather.forecast

import com.tamarcusg.openweather.repository.model.Forecast
import com.tamarcusg.openweather.util.UIEvent

internal sealed class ForecastUIEvent: UIEvent {
    data class PopulateForecastList(val forecasts: List<Forecast>) : ForecastUIEvent()
    data class ForecastClicked(val forecast: Forecast) : ForecastUIEvent()
    data object DismissBottomSheet : ForecastUIEvent()
}