package com.example.weatherapp.Model

import com.example.weatherapp.Data.Model.ForecastResponse

data class Weather(
    val temperature: Int,
    val date: String,
    val wind: Int,
    val humidity: Int,
    val feelsLike: Int,
    val condition: ForecastResponse.Current.Condition,
    val uv: Int,
    val name: String,
    val forecasts: List<Forecast>
)
