package ua.yahniukov.uptodo.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ua.yahniukov.uptodo.data.local.dao.TaskDao
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import ua.yahniukov.uptodo.data.local.models.typeconverters.LocalDateConverter

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
@TypeConverters(LocalDateConverter::class)
abstract class UpTodoDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}