package com.example.weatherapp.Data.Model.Repository

import com.example.weatherapp.Model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherForecast(city: String): Flow<Result<Weather>>
}
