package ua.yahniukov.uptodo.utils

import androidx.appcompat.app.AppCompatDelegate

object Graphs {
    const val ROOT = "root_graph"
    const val HOME = "home_graph"
}

object Destinations {
    const val ONBOARDING = "onboarding"
    const val TASKS = "tasks"
    const val CALENDAR = "calendar"
    const val ADD_EDIT = "addEdit/{taskId}"
    const val SETTINGS = "settings"
    const val TASK = "task/{taskId}"
}

object NavArguments {
    const val TASK_ID = "taskId"
}

object DataStore {
    const val NAME = "UpTodo"
    const val IS_ONBOARDING_COMPLETED_KEY = "isOnboardingCompletedKey"
    const val IS_ONBOARDING_COMPLETED_DEFAULT = false
    const val THEME_MODE_KEY = "themeModeKey"
    const val THEME_MODE_DEFAULT = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
}

object Database {
    const val NAME = "UpTodo.db"
    const val TABLE_TASKS = "tasks"
}