package com.tamarcusg.openweather.home

import com.tamarcusg.openweather.util.UIEvent

internal sealed class HomeUIEvent : UIEvent {
    data class SearchStringChanged(val newString: String) : HomeUIEvent()
    data object OnSearchClick : HomeUIEvent()
}