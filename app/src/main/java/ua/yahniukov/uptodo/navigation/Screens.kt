package ua.yahniukov.uptodo.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ua.yahniukov.uptodo.R
import ua.yahniukov.uptodo.utils.Destinations

sealed class RootScreens(val route: String) {
    object Onboarding : RootScreens(route = Destinations.ONBOARDING)
}

sealed class HomeScreens(val route: String) {
    object AddEdit : HomeScreens(route = Destinations.ADD_EDIT) {
        fun putTaskId(taskId: Long): String {
            return "addEdit/${taskId}"
        }
    }

    object Task : HomeScreens(route = Destinations.TASK) {
        fun putTaskId(taskId: Long): String {
            return "task/${taskId}"
        }
    }
}

sealed class BottomBarScreens(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    @DrawableRes val activeIcon: Int,
) {
    object Tasks : BottomBarScreens(
        route = Destinations.TASKS,
        title = R.string.tasks,
        icon = R.drawable.ic_home_outlined,
        activeIcon = R.drawable.ic_home_filled,
    )

    object Calendar : BottomBarScreens(
        route = Destinations.CALENDAR,
        title = R.string.calendar,
        icon = R.drawable.ic_calendar_outlined,
        activeIcon = R.drawable.ic_calendar_filled,
    )

    object Settings : BottomBarScreens(
        route = Destinations.SETTINGS,
        title = R.string.settings,
        icon = R.drawable.ic_settings_outlined,
        activeIcon = R.drawable.ic_settings_filled,
    )
}