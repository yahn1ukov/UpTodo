package ua.yahniukov.uptodo.domain.usecases.task

data class TaskUseCase(
    val fetchAllTasksUseCase: FetchAllTasksUseCase,
    val fetchAllTasksByPlannedDateUseCase: FetchAllTasksByPlannedDateUseCase,
    val fetchByIdTaskUseCase: FetchByIdTaskUseCase,
    val searchTaskUseCase: SearchTaskUseCase,
    val createTaskUseCase: CreateTaskUseCase,
    val updateTaskUseCase: UpdateTaskUseCase,
    val deleteTaskUseCase: DeleteTaskUseCase,
    val deleteAllTasksUseCase: DeleteAllTasksUseCase,
)