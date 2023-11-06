package ua.yahniukov.uptodo.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity

@Composable
fun TaskList(
    modifier: Modifier = Modifier,
    tasks: List<TaskEntity>,
    onTap: (Long) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(
            items = tasks,
            key = { task -> task.id }
        ) { task ->
            TaskListItem(
                modifier = Modifier.clickable { onTap(task.id) },
                task = task,
            )
        }
    }
}