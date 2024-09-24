Weather is an Android app for Weather check. It uses openweathermap API. It is single screen app which displays weather data for a city.

Architecture: The app is built with the Model-View-ViewModel (MVVM) architecture with Repository pattern which is used to separate the app's user interface, logic, and data.

To visualize the flow:

User opens the app and sees the main weather screen with weather details of the default city - New Delhi.
User types a city name into the search bar.
The app's ViewModel, through the Repository, makes a call to the OpenWeatherMap API.
The API returns the weather data for the requested city.
The Repository passes this data to the ViewModel.
The ViewModel updates the View (the screen) with the fetched weather data, displaying it to the user.
