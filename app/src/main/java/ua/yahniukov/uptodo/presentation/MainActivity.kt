package ua.yahniukov.uptodo.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ua.yahniukov.uptodo.navigation.RootGraph
import ua.yahniukov.uptodo.presentation.theme.UpTodoTheme

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            mainViewModel.isSplashLoading.value
        }
        setContent {
            val uiState by mainViewModel.uiState.collectAsStateWithLifecycle()

            UpTodoTheme(
                darkTheme = when (uiState.themeMode) {
                    AppCompatDelegate.MODE_NIGHT_NO -> false
                    AppCompatDelegate.MODE_NIGHT_YES -> true
                    else -> isSystemInDarkTheme()
                }
            ) {
                val navController = rememberNavController()

                RootGraph(
                    navController = navController,
                    startDestination = uiState.startDestination,
                    themeMode = uiState.themeMode,
                )
            }
        }
    }
}