package ua.yahniukov.uptodo.presentation

import ua.yahniukov.uptodo.navigation.RootScreens
import ua.yahniukov.uptodo.utils.DataStore

data class MainUiState(
    val themeMode: Int = DataStore.THEME_MODE_DEFAULT,
    val startDestination: String = RootScreens.Onboarding.route
)