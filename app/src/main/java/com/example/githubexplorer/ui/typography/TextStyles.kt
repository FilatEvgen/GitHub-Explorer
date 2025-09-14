package com.example.githubexplorer.ui.typography

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle

@Stable
interface AppTypography {
    val Heading: Heading
    val Body: Body
    val Caption: Caption
}

interface Heading {
    val Heading1: TextStyle
    val Heading2: TextStyle
    val Heading3: TextStyle
    val Heading4: TextStyle
    val Heading5: TextStyle
    val Heading6: TextStyle
}

interface Body {
    val BodyLarge: TextStyle
    val BodyMedium: TextStyle
}

interface Caption {
    val CaptionRegular: TextStyle
    val CaptionSmall: TextStyle
}
