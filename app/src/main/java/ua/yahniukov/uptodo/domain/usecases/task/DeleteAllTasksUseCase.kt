package ua.yahniukov.uptodo.domain.usecases.task

import ua.yahniukov.uptodo.domain.repositories.TaskRepository

class DeleteAllTasksUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke() {
        taskRepository.deleteAll()
    }
}