package com.example.weatherapp.Module

import com.example.weatherapp.Data.Model.Network.WeatherApi
import com.example.weatherapp.Data.Model.Repository.DefaultWeatherRepository
import com.example.weatherapp.Data.Model.Repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(weatherApi: WeatherApi): WeatherRepository =
        DefaultWeatherRepository(weatherApi)
}