package com.example.githubexplorer.ui.colors

import androidx.compose.ui.graphics.Color

object Colors : AppColors {
    override val Background: ColorPalette = BackgroundPalette
    override val Text: ColorPalette = TextPalette
    override val Icon: ColorPalette = IconPalette
    override val Interaction: InteractionColors = InteractionPalette
}

private object BackgroundPalette: ColorPalette {
    override val Primary = Color(0xFFFFFFFF)
    override val Secondary = Color(0xFFF6F8FA)
    override val Tertiary = Color(0xFFE1E4E8)
    override val Inverted = Color(0xFF111827)
    override val Accent = Color(0xFFFACC15)
}

private object TextPalette: ColorPalette {
    override val Primary = Color(0xFF111827)
    override val Secondary = Color(0xFF586069)
    override val Tertiary = Color(0xFF9CA3AF)
    override val Accent = Color(0xFF0366D6)
    override val Inverted = Color(0xFFFFFFFF)
}

private object IconPalette:  ColorPalette {
    override val Primary = Color(0xFF111827)
    override val Secondary = Color(0xFF586069)
    override val Tertiary = Color(0xFF9CA3AF)
    override val Accent = Color(0xFFFACC15)
    override val Inverted = Color(0xFFFFFFFF)
}

private object InteractionPalette: InteractionColors {
    override val Warning = Color(0xFFFACC15)
    override val Success = Color(0xFF22C55E)
    override val Error = Color(0xFFEF4444)
}

