package com.enesk.weatherapp.domain.repository

import com.enesk.weatherapp.domain.weather.WeatherInfo
import com.enesk.weatherapp.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}