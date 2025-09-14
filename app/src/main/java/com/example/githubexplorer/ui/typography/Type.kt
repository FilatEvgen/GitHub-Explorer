package com.example.githubexplorer.ui.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.githubexplorer.R
import androidx.compose.ui.text.font.Font

class Typography(private val fontFamily: FontFamily) : AppTypography {
    companion object {
        @Composable
        fun create(): Typography = Typography(createFontFamily())
    }

    override val Heading: Heading = GetHeading(fontFamily)
    override val Body: Body = GetBody(fontFamily)
    override val Caption: Caption = GetCaption(fontFamily)
}

    @Composable
    fun createFontFamily(): FontFamily = FontFamily(
        Font(R.font.inter_regular, weight = FontWeight.Normal),
        Font(R.font.inter_medium, weight = FontWeight.Medium),
        Font(R.font.inter_semi_bold, weight = FontWeight.SemiBold),
        Font(R.font.inter_bold, weight = FontWeight.Bold)
    )

    private fun GetHeading(fontFamily: FontFamily): Heading {
        return object : Heading {
            override val Heading1: TextStyle =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            override val Heading2: TextStyle =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            override val Heading3: TextStyle =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            override val Heading4: TextStyle =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            override val Heading5: TextStyle =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
            override val Heading6: TextStyle =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
        }
    }

    private fun GetBody(fontFamily: FontFamily): Body {
        return object : Body {
            override val BodyLarge: TextStyle =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            override val BodyMedium: TextStyle =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
        }
    }

    private fun GetCaption(fontFamily: FontFamily): Caption {
        return object : Caption {
            override val CaptionRegular: TextStyle =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                )
            override val CaptionSmall: TextStyle =
                TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
        }
    }



