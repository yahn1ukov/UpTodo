package ua.yahniukov.uptodo.presentation.screens.home.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ua.yahniukov.uptodo.presentation.components.EmptyContent
import ua.yahniukov.uptodo.presentation.components.LoadingContent
import ua.yahniukov.uptodo.presentation.screens.home.tasks.components.SearchTextField
import ua.yahniukov.uptodo.presentation.screens.home.tasks.components.TasksContent

@Composable
fun TasksScreen(
    onNavigateToTaskScreen: (Long) -> Unit,
    tasksViewModel: TasksViewModel = koinViewModel(),
) {
    val uiState by tasksViewModel.uiState.collectAsStateWithLifecycle()

    var query by remember { mutableStateOf("") }

    LaunchedEffect(key1 = query) {
        if (query.isEmpty()) {
            tasksViewModel.fetchAllTasks()
        } else {
            tasksViewModel.searchTasks(query)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        SearchTextField(
            modifier = Modifier.fillMaxWidth(),
            query = query,
            onQueryChange = { query = it },
        )
        when {
            uiState.isLoading -> {
                LoadingContent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                )
            }

            uiState.tasks.isEmpty() -> {
                EmptyContent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                )
            }

            uiState.tasks.isNotEmpty() -> {
                TasksContent(
                    modifier = Modifier.weight(1f),
                    tasks = uiState.tasks,
                    onNavigateToTaskScreen = onNavigateToTaskScreen,
                )
            }
        }
    }
}