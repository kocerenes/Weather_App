package com.enesk.weatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.enesk.weatherapp.data.mapper.toWeatherInfo
import com.enesk.weatherapp.data.remote.WeatherApi
import com.enesk.weatherapp.domain.repository.WeatherRepository
import com.enesk.weatherapp.domain.weather.WeatherInfo
import com.enesk.weatherapp.util.Resource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(lat, long).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "an unknown error occurred")
        }
    }
}