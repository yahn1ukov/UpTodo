package ua.yahniukov.uptodo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.yahniukov.uptodo.domain.usecases.dataStore.DataStoreUseCase
import ua.yahniukov.uptodo.utils.Graphs

class MainViewModel(private val dataStoreUseCase: DataStoreUseCase) : ViewModel() {
    private val _isSplashLoading = MutableStateFlow(true)
    val isSplashLoading = _isSplashLoading.asStateFlow()

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getDataStoreValues()
    }

    private fun getDataStoreValues() {
        viewModelScope.launch {
            combine(
                dataStoreUseCase.getThemeModeUseCase(),
                dataStoreUseCase.getOnboardingCompletedUseCase()
            ) { themeMode, isCompleted -> themeMode to isCompleted }.collect { (themeMode, isCompleted) ->
                _uiState.update { it.copy(themeMode = themeMode) }
                if (isCompleted) {
                    _uiState.update { it.copy(startDestination = Graphs.HOME) }
                }
                delay(100)
                _isSplashLoading.update { false }
            }
        }
    }
}