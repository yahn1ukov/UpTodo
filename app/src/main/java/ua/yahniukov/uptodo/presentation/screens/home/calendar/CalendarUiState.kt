package ua.yahniukov.uptodo.presentation.screens.home.calendar

import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity

data class CalendarUiState(
    val isLoading: Boolean = false,
    val tasks: List<TaskEntity> = emptyList(),
)