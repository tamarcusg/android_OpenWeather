package com.tamarcusg.openweather.navigation

internal data class TopAppBarUIState(
    val isVisible: Boolean = false,
    val title: String = "",
    val onBack: () -> Unit = {}
)