package com.tamarcusg.openweather.repository

import com.tamarcusg.openweather.BuildConfig
import com.tamarcusg.openweather.repository.dto.CityForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiService {

    @GET("data/2.5/forecast")
    suspend fun getCityForecastData(
        @Query("q") city: String,
        @Query("units") units: String = "imperial",
        @Query("appid") apiKey: String = BuildConfig.OPEN_WEATHER_API_KEY,
    ): CityForecastDto
}