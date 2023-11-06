package ua.yahniukov.uptodo.domain.usecases.task

import kotlinx.coroutines.flow.Flow
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import ua.yahniukov.uptodo.domain.repositories.TaskRepository

class FetchAllTasksUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke(): Flow<List<TaskEntity>> {
        return taskRepository.fetchAll()
    }
}