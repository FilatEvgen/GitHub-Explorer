import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.example.githubexplorer.model.UserUiModel
import com.example.githubexplorer.ui.theme.AppTheme

@Composable
fun UserListItem(
    user: UserUiModel,
    onClick: (UserUiModel) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { onClick(user) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(user.avatarUrl),
            contentDescription = "${user.login} avatar",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = user.name ?: user.login, style = AppTheme.typography.Heading.Heading3)
            Text(text = "@${user.login}", style = AppTheme.typography.Body.BodyMedium, color = AppTheme.colors.Text.Secondary)
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(text = "${user.followers} followers", style = AppTheme.typography.Caption.CaptionRegular, color = AppTheme.colors.Text.Tertiary)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "${user.publicRepos} repos", style = AppTheme.typography.Caption.CaptionRegular, color = AppTheme.colors.Text.Tertiary)
            }
        }
    }
}
