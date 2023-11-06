package ua.yahniukov.uptodo.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import java.time.LocalDate

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY id ASC")
    fun fetchAll(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks WHERE planned_at=:plannedAt")
    fun fetchAllByPlannedAt(plannedAt: LocalDate): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks WHERE id=:id")
    fun fetchById(id: Long): Flow<TaskEntity>

    @Query("SELECT * FROM tasks WHERE title LIKE :query")
    fun search(query: String): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(task: TaskEntity)

    @Update
    suspend fun update(task: TaskEntity)

    @Delete
    suspend fun delete(task: TaskEntity)

    @Query("DELETE FROM tasks")
    suspend fun deleteAll()
}