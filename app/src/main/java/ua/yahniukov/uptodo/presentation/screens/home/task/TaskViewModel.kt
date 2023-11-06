package ua.yahniukov.uptodo.presentation.screens.home.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import ua.yahniukov.uptodo.domain.usecases.task.TaskUseCase

class TaskViewModel(private val taskUseCase: TaskUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(TaskUiState())
    val uiState = _uiState.asStateFlow()

    fun fetchTaskById(id: Long) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            taskUseCase.fetchByIdTaskUseCase(id).collect { task ->
                _uiState.update { it.copy(isLoading = false, task = task) }
            }
        }
    }

    fun deleteTask(task: TaskEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            taskUseCase.deleteTaskUseCase(task)
        }
    }
}