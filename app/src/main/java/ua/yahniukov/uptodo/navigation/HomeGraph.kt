package ua.yahniukov.uptodo.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ua.yahniukov.uptodo.presentation.screens.home.addEdit.AddEditScreen
import ua.yahniukov.uptodo.presentation.screens.home.calendar.CalendarScreen
import ua.yahniukov.uptodo.presentation.screens.home.settings.SettingsScreen
import ua.yahniukov.uptodo.presentation.screens.home.task.TaskScreen
import ua.yahniukov.uptodo.presentation.screens.home.tasks.TasksScreen
import ua.yahniukov.uptodo.utils.Graphs
import ua.yahniukov.uptodo.utils.NavArguments

@Composable
fun HomeGraph(
    padding: PaddingValues,
    themeMode: Int,
    navController: NavHostController,
) {
    NavHost(
        modifier = Modifier.padding(padding),
        navController = navController,
        route = Graphs.HOME,
        startDestination = BottomBarScreens.Tasks.route,
    ) {
        composable(route = BottomBarScreens.Tasks.route) {
            TasksScreen(
                onNavigateToTaskScreen = { taskId ->
                    val route = HomeScreens.Task.putTaskId(taskId)
                    navController.navigate(route)
                }
            )
        }
        composable(route = BottomBarScreens.Calendar.route) {
            CalendarScreen(
                onNavigateToTaskScreen = { taskId ->
                    val route = HomeScreens.Task.putTaskId(taskId)
                    navController.navigate(route)
                }
            )
        }
        composable(route = BottomBarScreens.Settings.route) {
            SettingsScreen(themeMode = themeMode)
        }
        composable(
            route = HomeScreens.AddEdit.route,
            arguments = listOf(navArgument(NavArguments.TASK_ID) { type = NavType.LongType }),
        ) { navBackStack ->
            val taskId = navBackStack.arguments?.getLong(NavArguments.TASK_ID) ?: -1L

            AddEditScreen(
                taskId = taskId,
                onNavigateToBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = HomeScreens.Task.route,
            arguments = listOf(navArgument(NavArguments.TASK_ID) { type = NavType.LongType })
        ) { navBackStack ->
            val taskId = navBackStack.arguments?.getLong(NavArguments.TASK_ID)!!

            TaskScreen(
                taskId = taskId,
                onNavigateToBack = {
                    navController.popBackStack()
                },
                onNavigateToAddEditScreen = {
                    val route = HomeScreens.AddEdit.putTaskId(taskId)
                    navController.navigate(route)
                }
            )
        }
    }
}