package ua.yahniukov.uptodo.domain.usecases.dataStore

import kotlinx.coroutines.flow.Flow
import ua.yahniukov.uptodo.domain.repositories.DataStoreRepository

class GetOnboardingCompletedUseCase(private val dataStoreRepository: DataStoreRepository) {
    operator fun invoke(): Flow<Boolean> {
        return dataStoreRepository.getOnboardingCompleted()
    }
}