package com.example.githubexplorer.ui.theme

import androidx.compose.runtime.Composable
import com.example.githubexplorer.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.recipes.app.theme.Body
import ru.recipes.app.theme.Button
import ru.recipes.app.theme.Caption
import ru.recipes.app.theme.Heading

class Typography(private val fontFamily: FontFamily) : Heading, Body, Button, Caption {

    companion object {
        @Composable
        fun create(): Typography = Typography(createFontFamily())
    }

    // Heading
    override val Heading1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    )

    override val Heading2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    )

    override val Heading3 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )

    override val Heading4 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )

    override val Heading5 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    )

    // Body
    override val BodyLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )

    override val BodyMedium = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    override val BodySmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

    override val BodyExtraSmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.25.sp
    )

    // Button
    override val ButtonLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )

    override val ButtonMedium = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )

    // Caption
    override val CaptionRegular = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

    override val CaptionSmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    )
}

@Composable
fun createFontFamily(): FontFamily = FontFamily(
    Font(R.font.inter_regular, weight = FontWeight.Normal),
    Font(R.font.inter_medium, weight = FontWeight.Medium),
    Font(R.font.inter_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.inter_bold, weight = FontWeight.Bold)
)
