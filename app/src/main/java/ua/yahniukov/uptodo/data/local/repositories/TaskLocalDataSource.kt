package ua.yahniukov.uptodo.data.local.repositories

import kotlinx.coroutines.flow.Flow
import ua.yahniukov.uptodo.data.local.dao.TaskDao
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import java.time.LocalDate

class TaskLocalDataSource(private val taskDao: TaskDao) {
    fun fetchAll(): Flow<List<TaskEntity>> {
        return taskDao.fetchAll()
    }

    fun fetchAllByPlannedAt(plannedAt: LocalDate): Flow<List<TaskEntity>> {
        return taskDao.fetchAllByPlannedAt(plannedAt)
    }

    fun fetchById(id: Long): Flow<TaskEntity> {
        return taskDao.fetchById(id)
    }

    fun search(query: String): Flow<List<TaskEntity>> {
        return taskDao.search(query)
    }

    suspend fun create(task: TaskEntity) {
        taskDao.create(task)
    }

    suspend fun update(task: TaskEntity) {
        taskDao.update(task)
    }

    suspend fun delete(task: TaskEntity) {
        taskDao.delete(task)
    }

    suspend fun deleteAll() {
        taskDao.deleteAll()
    }
}