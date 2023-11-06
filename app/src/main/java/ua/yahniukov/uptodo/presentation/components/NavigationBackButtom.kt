package ua.yahniukov.uptodo.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import ua.yahniukov.uptodo.R

@Composable
fun NavigationBackButton(
    icon: ImageVector = Icons.AutoMirrored.Outlined.ArrowBack,
    onNavigateToBack: () -> Unit,
) {
    IconButton(onClick = onNavigateToBack) {
        Icon(
            imageVector = icon,
            contentDescription = stringResource(R.string.back_btn),
        )
    }
}