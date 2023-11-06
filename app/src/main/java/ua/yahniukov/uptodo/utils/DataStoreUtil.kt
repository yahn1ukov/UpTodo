package ua.yahniukov.uptodo.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.dataStore by preferencesDataStore(DataStore.NAME)

class DataStoreUtil(context: Context) {
    private val dataStore = context.dataStore

    private object PreferenceKeys {
        val isOnboardingCompletedKey =
            booleanPreferencesKey(DataStore.IS_ONBOARDING_COMPLETED_KEY)
        val themeModeKey = intPreferencesKey(DataStore.THEME_MODE_KEY)
    }

    suspend fun setOnboardingCompleted(isCompleted: Boolean) {
        dataStore.edit { preference ->
            preference[PreferenceKeys.isOnboardingCompletedKey] = isCompleted
        }
    }

    suspend fun setThemeMode(themeMode: Int) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.themeModeKey] = themeMode
        }
    }

    fun getOnboardingCompleted(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preference ->
                preference[PreferenceKeys.isOnboardingCompletedKey]
                    ?: DataStore.IS_ONBOARDING_COMPLETED_DEFAULT
            }
    }

    fun getThemeMode(): Flow<Int> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[PreferenceKeys.themeModeKey]
                    ?: DataStore.THEME_MODE_DEFAULT
            }
    }
}