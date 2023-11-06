package ua.yahniukov.uptodo.presentation.screens.home.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import ua.yahniukov.uptodo.navigation.BottomBarScreens

@Composable
fun HomeNavigationBar(
    screens: List<BottomBarScreens>,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    NavigationBar {
        screens.forEach { screen ->
            NavigationBarItem(
                alwaysShowLabel = true,
                icon = {
                    if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                        Icon(
                            painter = painterResource(screen.activeIcon),
                            contentDescription = stringResource(screen.title)
                        )
                    } else {
                        Icon(
                            painter = painterResource(screen.icon),
                            contentDescription = stringResource(screen.title)
                        )
                    }
                },
                label = {
                    Text(text = stringResource(screen.title))
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
            )
        }
    }
}