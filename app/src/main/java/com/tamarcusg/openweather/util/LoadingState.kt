package com.tamarcusg.openweather.util

import com.tamarcusg.openweather.repository.model.CityForecast

internal sealed class LoadingState {
    internal data object None : LoadingState()
    internal data object Loading : LoadingState()
    internal data class Loaded(
        val forecasts: CityForecast
    ) : LoadingState()
    internal data object Error : LoadingState()
}