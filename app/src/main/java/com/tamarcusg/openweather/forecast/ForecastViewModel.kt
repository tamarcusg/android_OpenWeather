package com.tamarcusg.openweather.forecast

import androidx.lifecycle.ViewModel
import com.tamarcusg.openweather.util.OpenWeatherViewModel
import com.tamarcusg.openweather.util.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class ForecastViewModel @Inject constructor() : OpenWeatherViewModel, ViewModel() {

    private val _state = MutableStateFlow(ForecastUIState())
    val state = _state.asStateFlow()

    override fun handleEvent(event: UIEvent) {
        when (event) {
            is ForecastUIEvent.PopulateForecastList -> {
                _state.update { it.copy(forecasts = event.forecasts) }
            }

            is ForecastUIEvent.ForecastClicked -> {
                _state.update {
                    it.copy(
                        selectedForecast = event.forecast,
                        isBottomSheetVisible = true
                    )
                }
            }

            is ForecastUIEvent.DismissBottomSheet -> {
                _state.update {
                    it.copy(
                        isBottomSheetVisible = false,
                        selectedForecast = null
                    )
                }
            }
        }
    }

}