package ua.yahniukov.uptodo.presentation.screens.home.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.yahniukov.uptodo.domain.usecases.task.TaskUseCase

class TasksViewModel(private val taskUseCase: TaskUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(TasksUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchAllTasks()
    }

    fun fetchAllTasks() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            taskUseCase.fetchAllTasksUseCase().collect { tasks ->
                _uiState.update { it.copy(isLoading = false, tasks = tasks) }
            }
        }
    }

    fun searchTasks(query: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            taskUseCase.searchTaskUseCase("%$query%").collect { tasks ->
                _uiState.update { it.copy(isLoading = false, tasks = tasks) }
            }
        }
    }
}