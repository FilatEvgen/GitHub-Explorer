package ru.recipes.app.theme

import androidx.compose.ui.text.TextStyle

interface Heading {
    val Heading1: TextStyle
    val Heading2: TextStyle
    val Heading3: TextStyle
    val Heading4: TextStyle
    val Heading5: TextStyle
}

interface Body {
    val BodyLarge: TextStyle
    val BodyMedium: TextStyle
    val BodySmall: TextStyle
    val BodyExtraSmall: TextStyle
}

interface Button {
    val ButtonLarge: TextStyle
    val ButtonMedium: TextStyle
}

interface Caption {
    val CaptionRegular: TextStyle
    val CaptionSmall: TextStyle
}