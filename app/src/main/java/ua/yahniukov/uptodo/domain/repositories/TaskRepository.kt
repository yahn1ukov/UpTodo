package ua.yahniukov.uptodo.domain.repositories

import kotlinx.coroutines.flow.Flow
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import java.time.LocalDate

interface TaskRepository {
    fun fetchAll(): Flow<List<TaskEntity>>
    fun fetchAllByPlannedAt(plannedAt: LocalDate): Flow<List<TaskEntity>>
    fun fetchById(id: Long): Flow<TaskEntity>
    fun search(query: String): Flow<List<TaskEntity>>
    suspend fun create(task: TaskEntity)
    suspend fun update(task: TaskEntity)
    suspend fun delete(task: TaskEntity)
    suspend fun deleteAll()
}