package ua.yahniukov.uptodo.presentation.screens.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ua.yahniukov.uptodo.navigation.BottomBarScreens
import ua.yahniukov.uptodo.navigation.HomeGraph
import ua.yahniukov.uptodo.navigation.HomeScreens
import ua.yahniukov.uptodo.presentation.screens.home.components.HomeFloatingActionButton
import ua.yahniukov.uptodo.presentation.screens.home.components.HomeNavigationBar
import ua.yahniukov.uptodo.presentation.screens.home.components.HomeTopAppBar

@Composable
fun HomeScreen(
    themeMode: Int,
    navController: NavHostController = rememberNavController(),
) {
    val bottomBarScreens = listOf(
        BottomBarScreens.Tasks,
        BottomBarScreens.Calendar,
        BottomBarScreens.Settings,
    )

    val navBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStack?.destination

    val currentScreen = bottomBarScreens.find { it.route == currentDestination?.route }

    Scaffold(
        topBar = {
            currentScreen?.let { screen ->
                HomeTopAppBar(screen = screen)
            }
        },
        bottomBar = {
            currentScreen?.let {
                HomeNavigationBar(
                    screens = bottomBarScreens,
                    currentDestination = currentDestination,
                    navController = navController,
                )
            }
        },
        floatingActionButton = {
            currentScreen?.let {
                HomeFloatingActionButton(
                    onNavigateToAddEditScreen = {
                        navController.navigate(HomeScreens.AddEdit.putTaskId(-1))
                    }
                )
            }
        }
    ) { padding ->
        HomeGraph(
            padding = padding,
            themeMode = themeMode,
            navController = navController,
        )
    }
}