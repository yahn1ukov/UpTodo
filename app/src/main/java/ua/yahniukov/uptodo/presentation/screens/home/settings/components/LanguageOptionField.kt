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
import ua.yahniukov.uptodo.presentation.data.Language
import java.util.Locale

@Composable
fun LanguageOptionField(
    modifier: Modifier = Modifier,
    languages: List<Language>,
    onLanguageChange: (String) -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        languages.forEach { language ->
            Chip(
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f)
                    .clickable { onLanguageChange(language.code) },
                icon = painterResource(language.icon),
                iconSize = 16.dp,
                label = stringResource(language.name),
                labelSize = 14.sp,
                containerColor = if (Locale.getDefault().language == language.code) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.background
                },
                borderColor = if (Locale.getDefault().language == language.code) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.outline
                },
            )
        }
    }
}