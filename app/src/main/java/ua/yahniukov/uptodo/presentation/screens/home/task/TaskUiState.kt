package ua.yahniukov.uptodo.presentation.screens.home.task

import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity

data class TaskUiState(
    val isLoading: Boolean = false,
    val task: TaskEntity? = null,
)