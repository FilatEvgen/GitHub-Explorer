package com.example.githubexplorer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.githubexplorer.R
import com.example.githubexplorer.ui.theme.AppTheme

@Composable
fun SimpleSearchBar(
    modifier: Modifier = Modifier,
    placeholderText: String = stringResource(R.string.search_github_users),
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(46.dp)
            .background(
                color = AppTheme.colors.Background.Tertiary,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.magnifer_grey),
            contentDescription = "Search Icon",
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = placeholderText,
            color = AppTheme.colors.Text.Secondary,
            style = AppTheme.typography.Body.BodyLarge
        )
    }
}
