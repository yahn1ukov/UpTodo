package ua.yahniukov.uptodo.presentation.screens.home.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import ua.yahniukov.uptodo.navigation.BottomBarScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(screen: BottomBarScreens) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(screen.title),
                fontSize = 20.sp,
            )
        }
    )
}