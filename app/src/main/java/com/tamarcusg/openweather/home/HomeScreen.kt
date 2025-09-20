package com.tamarcusg.openweather.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tamarcusg.openweather.preview.OpenWeatherPreview

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text("HOWDY PARTNER")
    }
}

@OpenWeatherPreview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}