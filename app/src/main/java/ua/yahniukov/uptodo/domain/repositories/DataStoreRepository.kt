package ua.yahniukov.uptodo.domain.repositories

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    fun getOnboardingCompleted(): Flow<Boolean>
    suspend fun setOnboardingCompleted(isCompleted: Boolean)
    fun getDarkTheme(): Flow<Int>
    suspend fun setThemeMode(themeMode: Int)
}