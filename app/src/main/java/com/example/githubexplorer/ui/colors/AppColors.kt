package com.example.githubexplorer.ui.colors

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

@Stable
interface AppColors {
    val Background: ColorPalette
    val Text: ColorPalette
    val Icon: ColorPalette
    val Interaction: InteractionColors
}

@Stable
interface ColorPalette {
    val Primary: Color
    val Secondary: Color
    val Tertiary: Color
    val Accent: Color
    val Inverted: Color
}

@Stable
interface InteractionColors {
    val Warning: Color
    val Success: Color
    val Error: Color
}
