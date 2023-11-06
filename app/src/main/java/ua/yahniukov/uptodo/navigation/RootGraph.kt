package ua.yahniukov.uptodo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ua.yahniukov.uptodo.presentation.screens.home.HomeScreen
import ua.yahniukov.uptodo.presentation.screens.onboarding.OnboardingScreen
import ua.yahniukov.uptodo.utils.Graphs

@Composable
fun RootGraph(
    navController: NavHostController,
    startDestination: String,
    themeMode: Int,
) {
    NavHost(
        navController = navController,
        route = Graphs.ROOT,
        startDestination = startDestination,
    ) {
        composable(route = RootScreens.Onboarding.route) {
            OnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.popBackStack()
                    navController.navigate(Graphs.HOME)
                }
            )
        }
        composable(route = Graphs.HOME) {
            HomeScreen(themeMode = themeMode)
        }
    }
}