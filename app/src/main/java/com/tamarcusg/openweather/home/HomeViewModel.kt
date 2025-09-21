package com.tamarcusg.openweather.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamarcusg.openweather.repository.ApiResult
import com.tamarcusg.openweather.repository.OpenWeatherRepository
import com.tamarcusg.openweather.util.LoadingState
import com.tamarcusg.openweather.util.OpenWeatherViewModel
import com.tamarcusg.openweather.util.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val openWeatherRepository: OpenWeatherRepository
) : OpenWeatherViewModel, ViewModel() {

    private val _state = MutableStateFlow(HomeUIState())
    val state = _state.asStateFlow()

    override fun handleEvent(event: UIEvent) {
        when (event) {
            is HomeUIEvent.SearchStringChanged -> {
                _state.update { it.copy(searchString = event.newString) }
            }

            is HomeUIEvent.OnSearchClick -> {
                viewModelScope.launch {
                    _state.update { it.copy(loadingState = LoadingState.Loading) }
                    when (val result = openWeatherRepository.getCityForecast(state.value.searchString)) {
                        is ApiResult.Success -> {
                            _state.update {
                                it.copy(loadingState = LoadingState.Loaded(result.data))
                            }
                        }

                        is ApiResult.Error -> {
                            _state.update { it.copy(loadingState = LoadingState.Error) }
                        }
                    }
                }
            }

            is HomeUIEvent.ResetState -> {
                _state.update { HomeUIState() }
            }
        }
    }
}