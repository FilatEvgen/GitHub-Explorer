package com.example.githubexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.githubexplorer.ui.colors.Colors
import com.example.githubexplorer.ui.screens.MainScreen
import com.example.githubexplorer.ui.theme.AppTheme
import com.example.githubexplorer.ui.typography.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(
                colors = Colors,
                typography = Typography.create()
            ) {
                MainScreen()
            }
        }
    }
}