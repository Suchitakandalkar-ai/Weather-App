package com.example.weatherapp.ui.theme.Weather.Components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Animation(modifier: Modifier = Modifier, animation: Int?) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(animation)
    )

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        speed = 2f,
    )

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = modifier,
    )
}