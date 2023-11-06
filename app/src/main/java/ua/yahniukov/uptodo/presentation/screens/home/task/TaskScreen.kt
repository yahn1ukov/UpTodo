package ua.yahniukov.uptodo.presentation.screens.home.task

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ua.yahniukov.uptodo.R
import ua.yahniukov.uptodo.presentation.components.Dialog
import ua.yahniukov.uptodo.presentation.components.EmptyContent
import ua.yahniukov.uptodo.presentation.components.LoadingContent
import ua.yahniukov.uptodo.presentation.screens.home.task.components.TaskContent
import ua.yahniukov.uptodo.presentation.screens.home.task.components.TaskTopAppBar

@Composable
fun TaskScreen(
    taskId: Long,
    onNavigateToBack: () -> Unit,
    onNavigateToAddEditScreen: () -> Unit,
    taskViewModel: TaskViewModel = koinViewModel(),
) {
    val uiState by taskViewModel.uiState.collectAsStateWithLifecycle()

    var isDeleteDialogShow by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = taskId) {
        taskViewModel.fetchTaskById(taskId)
    }

    Scaffold(
        topBar = {
            TaskTopAppBar(
                onNavigateToBack = onNavigateToBack,
                onNavigateToAddEditScreen = onNavigateToAddEditScreen,
                onDeleteDialogShow = { isDeleteDialogShow = true },
            )
        }
    ) { padding ->
        when {
            uiState.isLoading -> {
                LoadingContent(modifier = Modifier.fillMaxSize())
            }

            uiState.task == null -> {
                EmptyContent(modifier = Modifier.fillMaxSize())
            }

            uiState.task != null -> {
                if (isDeleteDialogShow) {
                    Dialog(
                        title = stringResource(R.string.delete_task_title),
                        text = stringResource(R.string.delete_task_description),
                        confirmButtonText = R.string.delete,
                        onDismiss = { isDeleteDialogShow = false },
                        onConfirm = {
                            taskViewModel.deleteTask(uiState.task!!)
                            isDeleteDialogShow = false
                            onNavigateToBack()
                        },
                    )
                }

                TaskContent(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    task = uiState.task!!,
                )
            }
        }
    }
}