package ua.yahniukov.uptodo.domain.dto

import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

data class AddEditTaskDto(
    val id: Long = 0,
    val title: String = "",
    val description: String = "",
    val priority: Int = 1,
    val plannedAt: Long? = null,
    val createdAt: LocalDate = LocalDate.now(),
)

fun AddEditTaskDto.toTaskEntity(): TaskEntity {
    return TaskEntity(
        id = id,
        title = title,
        description = description,
        priority = priority,
        plannedAt = plannedAt?.let {
            Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
        },
        createdAt = createdAt,
    )
}