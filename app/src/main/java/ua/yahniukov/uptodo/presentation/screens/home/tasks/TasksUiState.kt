package ua.yahniukov.uptodo.presentation.screens.home.tasks

import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity

data class TasksUiState(
    val isLoading: Boolean = false,
    val tasks: List<TaskEntity> = emptyList(),
)