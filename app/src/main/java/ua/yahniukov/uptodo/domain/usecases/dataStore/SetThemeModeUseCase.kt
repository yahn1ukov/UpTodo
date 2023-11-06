package ua.yahniukov.uptodo.domain.usecases.dataStore

import ua.yahniukov.uptodo.domain.repositories.DataStoreRepository

class SetThemeModeUseCase(private val dataStoreRepository: DataStoreRepository) {
    suspend operator fun invoke(themeMode: Int) {
        dataStoreRepository.setThemeMode(themeMode)
    }
}