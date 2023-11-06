package ua.yahniukov.uptodo.presentation.screens.home.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ua.yahniukov.uptodo.R
import ua.yahniukov.uptodo.presentation.components.Dialog
import ua.yahniukov.uptodo.presentation.data.Language
import ua.yahniukov.uptodo.presentation.data.ThemeMode
import ua.yahniukov.uptodo.presentation.screens.home.settings.components.DeleteAllTasksButton
import ua.yahniukov.uptodo.presentation.screens.home.settings.components.LanguageOptionField
import ua.yahniukov.uptodo.presentation.screens.home.settings.components.ThemeOptionField
import ua.yahniukov.uptodo.utils.findActivity
import ua.yahniukov.uptodo.utils.onLanguageChange

@Composable
fun SettingsScreen(
    themeMode: Int,
    settingsViewModel: SettingsViewModel = koinViewModel(),
) {
    val themes = listOf(
        ThemeMode.System,
        ThemeMode.Light,
        ThemeMode.Dark,
    )

    val languages = listOf(
        Language.English,
        Language.Ukrainian,
    )

    var isDeleteAllDialogShow by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (isDeleteAllDialogShow) {
        Dialog(
            title = stringResource(R.string.delete_all_tasks_title),
            text = stringResource(R.string.delete_all_tasks_description),
            confirmButtonText = R.string.delete_all,
            onDismiss = { isDeleteAllDialogShow = false },
            onConfirm = {
                settingsViewModel.deleteAllTasks()
                isDeleteAllDialogShow = false
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(text = stringResource(R.string.theme))
        Spacer(modifier = Modifier.height(6.dp))
        ThemeOptionField(
            modifier = Modifier.fillMaxWidth(),
            themes = themes,
            themeMode = themeMode,
            onThemeModeChange = { themeMode ->
                settingsViewModel.setThemeMode(themeMode)
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(R.string.language))
        Spacer(modifier = Modifier.height(6.dp))
        LanguageOptionField(
            modifier = Modifier.fillMaxWidth(),
            languages = languages,
            onLanguageChange = { language ->
                context.findActivity()?.runOnUiThread {
                    context.onLanguageChange(language)
                }
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        DeleteAllTasksButton(onDeleteAllDialogShow = { isDeleteAllDialogShow = it })
    }
}