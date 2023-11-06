package ua.yahniukov.uptodo.data.local.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ua.yahniukov.uptodo.utils.Database
import java.time.LocalDate

@Entity(tableName = Database.TABLE_TASKS)
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val description: String,
    val priority: Int,
    @ColumnInfo(name = "planned_at") val plannedAt: LocalDate?,
    @ColumnInfo(name = "created_at") val createdAt: LocalDate,
)