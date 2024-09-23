package com.example.weatherapp.ui.theme

import com.example.weatherapp.Model.Weather

data class WeatherUiState(
    val weather: Weather? = null,
    val isLoading: Boolean = false,
    val errorMessage: String = "",
)