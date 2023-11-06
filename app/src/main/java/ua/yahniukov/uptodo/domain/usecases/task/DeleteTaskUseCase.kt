package ua.yahniukov.uptodo.domain.usecases.task

import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import ua.yahniukov.uptodo.domain.repositories.TaskRepository

class DeleteTaskUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: TaskEntity) {
        taskRepository.delete(task)
    }
}