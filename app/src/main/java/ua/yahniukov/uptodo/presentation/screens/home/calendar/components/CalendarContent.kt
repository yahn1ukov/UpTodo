package ua.yahniukov.uptodo.presentation.screens.home.calendar.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import ua.yahniukov.uptodo.presentation.components.TaskList

@Composable
fun CalendarContent(
    modifier: Modifier = Modifier,
    tasks: List<TaskEntity>,
    onNavigateToTaskScreen: (Long) -> Unit,
) {
    Spacer(modifier = Modifier.height(16.dp))
    TaskList(
        modifier = modifier,
        tasks = tasks,
        onTap = onNavigateToTaskScreen,
    )
}