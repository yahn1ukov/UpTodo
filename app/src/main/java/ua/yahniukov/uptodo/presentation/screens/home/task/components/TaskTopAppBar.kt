package ua.yahniukov.uptodo.presentation.screens.home.task.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ua.yahniukov.uptodo.R
import ua.yahniukov.uptodo.presentation.components.NavigationBackButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskTopAppBar(
    onNavigateToBack: () -> Unit,
    onNavigateToAddEditScreen: () -> Unit,
    onDeleteDialogShow: () -> Unit,
) {
    TopAppBar(
        navigationIcon = {
            NavigationBackButton(onNavigateToBack = onNavigateToBack)
        },
        title = { },
        actions = {
            EditAction(onNavigateToAddEditScreen = onNavigateToAddEditScreen)
            DeleteAction(onDeleteDialogShow = onDeleteDialogShow)
        }
    )
}

@Composable
private fun EditAction(onNavigateToAddEditScreen: () -> Unit) {
    IconButton(onClick = onNavigateToAddEditScreen) {
        Icon(
            painter = painterResource(R.drawable.ic_pen),
            contentDescription = stringResource(R.string.edit),
        )
    }
}

@Composable
private fun DeleteAction(onDeleteDialogShow: () -> Unit) {
    IconButton(onClick = onDeleteDialogShow) {
        Icon(
            painter = painterResource(R.drawable.ic_bin),
            contentDescription = stringResource(R.string.delete),
        )
    }
}