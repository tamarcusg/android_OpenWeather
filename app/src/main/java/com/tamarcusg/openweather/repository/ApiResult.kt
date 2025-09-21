package com.tamarcusg.openweather.repository

internal sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data object Error: ApiResult<Nothing>()
}