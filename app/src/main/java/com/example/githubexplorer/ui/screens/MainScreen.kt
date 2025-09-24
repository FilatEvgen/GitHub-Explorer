package com.example.githubexplorer.ui.screens

import UserListItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.githubexplorer.R
import com.example.githubexplorer.model.UserUiModel
import com.example.githubexplorer.ui.colors.Colors
import com.example.githubexplorer.ui.components.SimpleSearchBar
import com.example.githubexplorer.ui.theme.AppTheme
import com.example.githubexplorer.ui.typography.Typography


@Composable
fun MainScreen(
    users: List<UserUiModel>,
    isLoading: Boolean,
    error: String?,
    onUserClick: (UserUiModel) -> Unit,
    onSearchClick: () -> Unit
) {
    val colors = Colors
    val typography = Typography.create()
    AppTheme(colors = colors, typography = typography) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.container_cat),
                        contentDescription = null,
                        modifier = Modifier
                            .size(23.25.dp, 32.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = stringResource(R.string.github_explorer),
                        style = AppTheme.typography.Heading.Heading1,
                        color = Colors.Text.Primary,
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 35.dp))
                    Button(
                        onClick = {},
                        modifier = Modifier.padding(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.three_dots),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 40.dp)
                        )
                        // TODO: Button content
                    }
                }
                SimpleSearchBar(onClick = {})
                Spacer(modifier = Modifier.padding(16.dp))
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 16.dp, vertical = 12.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
                    Text(
                        text = stringResource(R.string.popular_developers),
                        style = AppTheme.typography.Heading.Heading2,
                        color = AppTheme.colors.Text.Primary
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 28.dp))
                    Text(
                        text = stringResource(R.string.view_all),
                        style = AppTheme.typography.Heading.Heading6,
                        color = AppTheme.colors.Text.Accent
                    )
                    if (error != null) {
                        Text(
                            text = error,
                            color = Color.Red,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                    if (isLoading) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    } else {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(users) { user ->
                                UserListItem(user = user, onClick = onUserClick)
                            }
                        }
                    }

                }
            }
        }
    }
//}


