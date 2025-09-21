package com.tamarcusg.openweather.home

import com.tamarcusg.openweather.util.LoadingState

internal data class HomeUIState(
    val searchString: String = "",
    val loadingState: LoadingState = LoadingState.None,
)