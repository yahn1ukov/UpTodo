package ua.yahniukov.uptodo.data.repositories

import kotlinx.coroutines.flow.Flow
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import ua.yahniukov.uptodo.data.local.repositories.TaskLocalDataSource
import ua.yahniukov.uptodo.domain.repositories.TaskRepository
import java.time.LocalDate

class TaskRepositoryImpl(private val taskLocalDataSource: TaskLocalDataSource) : TaskRepository {
    override fun fetchAll(): Flow<List<TaskEntity>> {
        return taskLocalDataSource.fetchAll()
    }

    override fun fetchAllByPlannedAt(plannedAt: LocalDate): Flow<List<TaskEntity>> {
        return taskLocalDataSource.fetchAllByPlannedAt(plannedAt)
    }

    override fun fetchById(id: Long): Flow<TaskEntity> {
        return taskLocalDataSource.fetchById(id)
    }

    override fun search(query: String): Flow<List<TaskEntity>> {
        return taskLocalDataSource.search(query)
    }

    override suspend fun create(task: TaskEntity) {
        taskLocalDataSource.create(task)
    }

    override suspend fun update(task: TaskEntity) {
        taskLocalDataSource.update(task)
    }

    override suspend fun delete(task: TaskEntity) {
        taskLocalDataSource.delete(task)
    }

    override suspend fun deleteAll() {
        taskLocalDataSource.deleteAll()
    }
}