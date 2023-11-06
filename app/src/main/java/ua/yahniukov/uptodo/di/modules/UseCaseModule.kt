package ua.yahniukov.uptodo.di.modules

import org.koin.dsl.module
import ua.yahniukov.uptodo.domain.usecases.dataStore.DataStoreUseCase
import ua.yahniukov.uptodo.domain.usecases.dataStore.GetOnboardingCompletedUseCase
import ua.yahniukov.uptodo.domain.usecases.dataStore.GetThemeModeUseCase
import ua.yahniukov.uptodo.domain.usecases.dataStore.SetOnboardingCompletedUseCase
import ua.yahniukov.uptodo.domain.usecases.dataStore.SetThemeModeUseCase
import ua.yahniukov.uptodo.domain.usecases.task.CreateTaskUseCase
import ua.yahniukov.uptodo.domain.usecases.task.DeleteAllTasksUseCase
import ua.yahniukov.uptodo.domain.usecases.task.DeleteTaskUseCase
import ua.yahniukov.uptodo.domain.usecases.task.FetchAllTasksByPlannedDateUseCase
import ua.yahniukov.uptodo.domain.usecases.task.FetchAllTasksUseCase
import ua.yahniukov.uptodo.domain.usecases.task.FetchByIdTaskUseCase
import ua.yahniukov.uptodo.domain.usecases.task.SearchTaskUseCase
import ua.yahniukov.uptodo.domain.usecases.task.TaskUseCase
import ua.yahniukov.uptodo.domain.usecases.task.UpdateTaskUseCase

val useCaseModule = module {
    single { GetOnboardingCompletedUseCase(get()) }
    single { SetOnboardingCompletedUseCase(get()) }
    single { GetThemeModeUseCase(get()) }
    single { SetThemeModeUseCase(get()) }
    single { DataStoreUseCase(get(), get(), get(), get()) }

    single { FetchAllTasksUseCase(get()) }
    single { FetchByIdTaskUseCase(get()) }
    single { FetchAllTasksByPlannedDateUseCase(get()) }
    single { SearchTaskUseCase(get()) }
    single { CreateTaskUseCase(get()) }
    single { UpdateTaskUseCase(get()) }
    single { DeleteTaskUseCase(get()) }
    single { DeleteAllTasksUseCase(get()) }
    single { TaskUseCase(get(), get(), get(), get(), get(), get(), get(), get()) }
}