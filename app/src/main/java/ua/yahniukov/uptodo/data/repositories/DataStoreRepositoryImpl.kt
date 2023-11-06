package ua.yahniukov.uptodo.data.repositories

import kotlinx.coroutines.flow.Flow
import ua.yahniukov.uptodo.domain.repositories.DataStoreRepository
import ua.yahniukov.uptodo.utils.DataStoreUtil

class DataStoreRepositoryImpl(private val dataStoreUtil: DataStoreUtil) : DataStoreRepository {
    override fun getOnboardingCompleted(): Flow<Boolean> {
        return dataStoreUtil.getOnboardingCompleted()
    }

    override suspend fun setOnboardingCompleted(isCompleted: Boolean) {
        dataStoreUtil.setOnboardingCompleted(isCompleted)
    }

    override fun getDarkTheme(): Flow<Int> {
        return dataStoreUtil.getThemeMode()
    }

    override suspend fun setThemeMode(themeMode: Int) {
        dataStoreUtil.setThemeMode(themeMode)
    }
}