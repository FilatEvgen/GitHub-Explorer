package com.example.githubexplorer.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubexplorer.R
import com.example.githubexplorer.ui.colors.Colors
import com.example.githubexplorer.ui.theme.AppTheme

@Preview
@Composable
fun MainScreen() {
        Surface( color = AppTheme.colors.Background.Primary, modifier = Modifier.fillMaxSize(),) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
            {
                Box(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(R.drawable.cat_header),
                        contentDescription = null,

                        )

                    Text(
                        text = "GitHub Explorer",
                        style = AppTheme.typography.Heading.Heading1,
                        color = Colors.Text.Primary,
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Button(onClick = {}, modifier = Modifier.padding(16.dp)) {

                    }
                }
            }
        }
    }
