package ua.yahniukov.uptodo.di.modules

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ua.yahniukov.uptodo.data.local.database.UpTodoDatabase
import ua.yahniukov.uptodo.data.local.repositories.TaskLocalDataSource
import ua.yahniukov.uptodo.utils.Database

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            UpTodoDatabase::class.java,
            Database.NAME
        ).build()
    }

    single {
        val database = get<UpTodoDatabase>()
        database.taskDao()
    }

    single { TaskLocalDataSource(get()) }
}