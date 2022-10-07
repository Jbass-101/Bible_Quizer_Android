package com.jbaloji.biblequiz.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Primary_Dark,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = Teal200,
    background = Background_Dark


)

private val LightColorPalette = lightColors(
    primary = Primary_Light,
    primaryVariant = Color.Red,
    secondary = Color.Yellow,
    background = Background_Light

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BibleQuizTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {


    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}