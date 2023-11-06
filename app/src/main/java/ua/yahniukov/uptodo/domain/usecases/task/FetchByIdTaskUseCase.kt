package ua.yahniukov.uptodo.domain.usecases.task

import kotlinx.coroutines.flow.Flow
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import ua.yahniukov.uptodo.domain.repositories.TaskRepository

class FetchByIdTaskUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke(id: Long): Flow<TaskEntity> {
        return taskRepository.fetchById(id)
    }
}