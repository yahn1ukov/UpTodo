package ua.yahniukov.uptodo.domain.usecases.task

import kotlinx.coroutines.flow.Flow
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import ua.yahniukov.uptodo.domain.repositories.TaskRepository
import java.time.LocalDate

class FetchAllTasksByPlannedDateUseCase(private val taskRepository: TaskRepository) {
    operator fun invoke(plannedAt: LocalDate): Flow<List<TaskEntity>> {
        return taskRepository.fetchAllByPlannedAt(plannedAt)
    }
}