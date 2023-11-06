package ua.yahniukov.uptodo.presentation.screens.home.addEdit.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import ua.yahniukov.uptodo.presentation.components.NavigationBackButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditTopAppBar(onNavigateToBack: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            NavigationBackButton(onNavigateToBack = onNavigateToBack)
        },
        title = { }
    )
}