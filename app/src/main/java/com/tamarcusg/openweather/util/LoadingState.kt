package com.tamarcusg.openweather.util

import com.tamarcusg.openweather.repository.model.Forecast

internal sealed class LoadingState {
    internal data object None : LoadingState()
    internal data object Loading : LoadingState()
    internal data class Loaded(
        val forecasts: List<Forecast>
    ) : LoadingState()
    internal data object Error : LoadingState()
}