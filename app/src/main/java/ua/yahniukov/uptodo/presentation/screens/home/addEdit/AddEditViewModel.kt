package ua.yahniukov.uptodo.presentation.screens.home.addEdit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.yahniukov.uptodo.domain.dto.AddEditTaskDto
import ua.yahniukov.uptodo.domain.usecases.task.TaskUseCase
import java.time.ZoneId

class AddEditViewModel(private val taskUseCase: TaskUseCase) : ViewModel() {
    private val _addEditTaskDto = MutableStateFlow(AddEditTaskDto())
    val addEditTaskDto = _addEditTaskDto.asStateFlow()

    fun fetchTaskById(taskId: Long) {
        viewModelScope.launch {
            taskUseCase.fetchByIdTaskUseCase(taskId).collect { task ->
                _addEditTaskDto.update {
                    it.copy(
                        id = task.id,
                        title = task.title,
                        description = task.description,
                        priority = task.priority,
                        plannedAt = task.plannedAt
                            ?.atStartOfDay(ZoneId.systemDefault())
                            ?.toInstant()
                            ?.toEpochMilli(),
                        createdAt = task.createdAt,
                    )
                }
            }
        }
    }

    fun createTask() {
        viewModelScope.launch(Dispatchers.IO) {
            taskUseCase.createTaskUseCase(addEditTaskDto.value)
        }
    }

    fun updateTask() {
        viewModelScope.launch(Dispatchers.IO) {
            taskUseCase.updateTaskUseCase(addEditTaskDto.value)
        }
    }

    fun updateTitle(value: String) {
        _addEditTaskDto.update { it.copy(title = value) }
    }

    fun updateDescription(value: String) {
        _addEditTaskDto.update { it.copy(description = value) }
    }

    fun updatePriority(value: Int) {
        _addEditTaskDto.update { it.copy(priority = value) }
    }


    fun updatePlannedAt(value: Long?) {
        value?.let { plannedAt ->
            _addEditTaskDto.update { it.copy(plannedAt = plannedAt) }
        }
    }
}