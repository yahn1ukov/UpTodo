package ua.yahniukov.uptodo.domain.usecases.task

import ua.yahniukov.uptodo.domain.dto.AddEditTaskDto
import ua.yahniukov.uptodo.domain.dto.toTaskEntity
import ua.yahniukov.uptodo.domain.repositories.TaskRepository

class CreateTaskUseCase(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: AddEditTaskDto) {
        taskRepository.create(task.toTaskEntity())
    }
}