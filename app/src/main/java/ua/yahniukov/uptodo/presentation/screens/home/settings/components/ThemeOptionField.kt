package ua.yahniukov.uptodo.presentation.screens.home.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.yahniukov.uptodo.presentation.components.Chip
import ua.yahniukov.uptodo.presentation.data.ThemeMode

@Composable
fun ThemeOptionField(
    modifier: Modifier = Modifier,
    themes: List<ThemeMode>,
    themeMode: Int,
    onThemeModeChange: (Int) -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        themes.forEach { theme ->
            Chip(
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f)
                    .clickable { onThemeModeChange(theme.mode) },
                icon = painterResource(theme.icon),
                iconSize = 16.dp,
                label = stringResource(theme.name),
                labelSize = 14.sp,
                containerColor = if (themeMode == theme.mode) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.background
                },
                borderColor = if (themeMode == theme.mode) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.outline
                },
            )
        }
    }
}