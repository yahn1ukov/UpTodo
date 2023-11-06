package ua.yahniukov.uptodo.presentation.screens.home.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ua.yahniukov.uptodo.domain.usecases.dataStore.DataStoreUseCase
import ua.yahniukov.uptodo.domain.usecases.task.TaskUseCase

class SettingsViewModel(
    private val dataStoreUseCase: DataStoreUseCase,
    private val taskUseCase: TaskUseCase,
) : ViewModel() {
    fun setThemeMode(themeMode: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreUseCase.setThemeModeUseCase(themeMode)
        }
    }

    fun deleteAllTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            taskUseCase.deleteAllTasksUseCase()
        }
    }
}