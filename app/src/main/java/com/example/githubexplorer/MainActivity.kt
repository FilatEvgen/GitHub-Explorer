package com.example.githubexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.githubexplorer.model.UserUiModel
import com.example.githubexplorer.ui.colors.Colors
import com.example.githubexplorer.ui.main.MainViewModel
import com.example.githubexplorer.ui.screens.MainScreen
import com.example.githubexplorer.ui.theme.AppTheme
import com.example.githubexplorer.ui.typography.Typography
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val users by viewModel.users.collectAsState()
            val isLoading by viewModel.isLoading.collectAsState()
            val error by viewModel.error.collectAsState()

            AppTheme(
                colors = Colors,
                typography = Typography.create()
            ) {
                MainScreen(
                    users = users,
                    isLoading = isLoading,
                    error = error,
                    onUserClick = { user: UserUiModel ->

                    },
                    onSearchClick = {
                    }
                )
            }
        }
    }
}
