package ua.yahniukov.uptodo.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ua.yahniukov.uptodo.domain.usecases.dataStore.DataStoreUseCase

class OnboardingViewModel(private val dataStoreUseCase: DataStoreUseCase) : ViewModel() {
    fun setOnBoardingCompleted(isCompleted: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreUseCase.setOnboardingCompletedUseCase(isCompleted)
        }
    }
}