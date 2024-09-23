package com.example.weatherapp

import com.example.weatherapp.Data.Model.Network.WeatherApi
import com.example.weatherapp.ui.theme.WeatherViewModel
import com.google.googlejavaformat.java.Main
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class WeatherViewModelTest {

    private lateinit var viewModel: WeatherViewModel
    private val mockApi = mockk<WeatherApi>() // Mock the WeatherApi

    // Setup test dispatcher for coroutines
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        // Set the Main dispatcher to the test dispatcher
        Dispatchers.setMain(testDispatcher)

        // Initialize ViewModel with the mocked API
        viewModel = WeatherViewModel(mockApi)
    }

    @After
    fun tearDown() {
        // Reset the Main dispatcher after each test
        Dispatchers.resetMain()
    }

    @Test
    fun `getWeatherForCity should update weatherState with weather data`() = runTest {
        // Arrange: Mock the API response
        val mockWeatherResponse = WeatherResponse(main = Main(temp = 25.0))
        coEvery { mockApi.getWeatherData(any(), any(), any()) } returns mockWeatherResponse

        // Act: Call the ViewModel method
        viewModel.getWeatherForCity("New Delhi")

        // Wait for the coroutine to finish
        advanceUntilIdle()

        // Assert: Check if the weatherState has been updated with the expected data
        val weatherState = viewModel.weatherState.first()
        assertEquals(25.0, weatherState?.main?.temp)
    }

    @Test
    fun `getWeatherForCity should handle error and weatherState should remain null`() = runTest {
        // Arrange: Mock an error in the API call
        coEvery { mockApi.getWeatherData(any(), any(), any()) } throws Exception("API error")

        // Act: Call the ViewModel method
        viewModel.getWeatherForCity("New Delhi")

        // Wait for the coroutine to finish
        advanceUntilIdle()

        // Assert: Check if the weatherState is still null after an error
        val weatherState = viewModel.weatherState.first()
        assertNull(weatherState)
    }
}
