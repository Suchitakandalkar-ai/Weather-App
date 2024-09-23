package com.example.weatherapp.Data.Model.Network

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.Data.Model.ForecastResponse
import com.example.weatherapp.Utils.DEFAULT_WEATHER_DESTINATION
import com.example.weatherapp.Utils.NUMBER_OF_DAYS
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("key") key: String ="API_KEY",
        @Query("q") city: String = DEFAULT_WEATHER_DESTINATION,
        @Query("days") days: Int = NUMBER_OF_DAYS,
    ): ForecastResponse
}