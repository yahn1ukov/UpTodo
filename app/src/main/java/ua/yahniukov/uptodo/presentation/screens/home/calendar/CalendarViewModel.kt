package ua.yahniukov.uptodo.presentation.screens.home.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.yahniukov.uptodo.domain.usecases.task.TaskUseCase
import java.time.LocalDate

class CalendarViewModel(private val taskUseCase: TaskUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(CalendarUiState())
    val uiState = _uiState.asStateFlow()

    fun fetchAllTasksByPlannedAt(date: LocalDate) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            taskUseCase.fetchAllTasksByPlannedDateUseCase(date).collect { tasks ->
                _uiState.update { it.copy(isLoading = false, tasks = tasks) }
            }
        }
    }
}