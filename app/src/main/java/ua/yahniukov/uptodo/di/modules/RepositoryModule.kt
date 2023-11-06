package ua.yahniukov.uptodo.di.modules

import org.koin.dsl.module
import ua.yahniukov.uptodo.data.repositories.DataStoreRepositoryImpl
import ua.yahniukov.uptodo.data.repositories.TaskRepositoryImpl
import ua.yahniukov.uptodo.domain.repositories.DataStoreRepository
import ua.yahniukov.uptodo.domain.repositories.TaskRepository

val repositoryModule = module {
    single<DataStoreRepository> {
        DataStoreRepositoryImpl(get())
    }

    single<TaskRepository> {
        TaskRepositoryImpl(get())
    }
}