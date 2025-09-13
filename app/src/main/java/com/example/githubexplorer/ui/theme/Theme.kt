package com.example.githubexplorer.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Colors.PrimaryVariant,
    onPrimary = Colors.BackgroundDark,
    background = Colors.BackgroundDark,
    surface = Colors.SurfaceDark,
    onBackground = Colors.TextPrimary,
    onSurface = Colors.TextPrimary,
    secondary = Colors.TextSecondary,
    onSecondary = Colors.BackgroundDark,
    error = Color.Red,
    onError = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Colors.Primary,
    onPrimary = Colors.BackgroundLight,
    background = Colors.BackgroundLight,
    surface = Colors.SurfaceLight,
    onBackground = Colors.TextPrimary,
    onSurface = Colors.TextPrimary,
    secondary = Colors.TextSecondary,
    onSecondary = Colors.BackgroundLight,
    error = Color.Red,
    onError = Color.White
)

@Composable
fun GitHubExplorerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val typography = Typography.create()

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(
            displayLarge = typography.Heading5,
            headlineLarge = typography.Heading1,
            headlineMedium = typography.Heading2,
            headlineSmall = typography.Heading3,
            titleLarge = typography.Heading4,
            bodyLarge = typography.BodyMedium,
            bodyMedium = typography.BodyLarge,
            bodySmall = typography.BodySmall,
            labelLarge = typography.ButtonLarge,
            labelMedium = typography.ButtonMedium,
            labelSmall = typography.CaptionRegular
        ),
        content = content
    )
}
