package ua.yahniukov.uptodo.presentation.screens.home.components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ua.yahniukov.uptodo.R

@Composable
fun HomeFloatingActionButton(onNavigateToAddEditScreen: () -> Unit) {
    FloatingActionButton(onClick = onNavigateToAddEditScreen) {
        Icon(
            painter = painterResource(R.drawable.ic_pen),
            contentDescription = stringResource(R.string.create),
        )
    }
}