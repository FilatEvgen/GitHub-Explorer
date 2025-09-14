package com.example.githubexplorer.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.githubexplorer.ui.colors.AppColors
import com.example.githubexplorer.ui.typography.AppTypography

@Composable
fun AppTheme(
    colors: AppColors,
    typography: AppTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides typography
    ) {
        content()
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalAppColors.current
    val typography: AppTypography
        @Composable
        get() = LocalAppTypography.current
}

val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("AppColors not provided")
}

val LocalAppTypography = staticCompositionLocalOf<AppTypography> {
    error("AppTypography not provided")
}