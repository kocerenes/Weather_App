package com.enesk.weatherapp.data.remote.dto

import com.squareup.moshi.Json

data class WeatherDto(
    @field: Json(name = "hourly")
    val weatherData : WeatherDataDto
)
