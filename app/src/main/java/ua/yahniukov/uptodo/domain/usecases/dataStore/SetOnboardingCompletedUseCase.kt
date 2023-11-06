package ua.yahniukov.uptodo.domain.usecases.dataStore

import ua.yahniukov.uptodo.domain.repositories.DataStoreRepository

class SetOnboardingCompletedUseCase(private val dataStoreRepository: DataStoreRepository) {
    suspend operator fun invoke(isCompleted: Boolean) {
        dataStoreRepository.setOnboardingCompleted(isCompleted)
    }
}