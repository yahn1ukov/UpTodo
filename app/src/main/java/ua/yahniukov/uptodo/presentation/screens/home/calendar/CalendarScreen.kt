package ua.yahniukov.uptodo.presentation.screens.home.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import ua.yahniukov.uptodo.presentation.components.EmptyContent
import ua.yahniukov.uptodo.presentation.components.LoadingContent
import ua.yahniukov.uptodo.presentation.screens.home.calendar.components.CalendarContent
import ua.yahniukov.uptodo.presentation.screens.home.calendar.components.CalendarDayList
import ua.yahniukov.uptodo.presentation.screens.home.calendar.components.CalendarHeader
import ua.yahniukov.uptodo.utils.CalendarUtil

@Composable
fun CalendarScreen(
    onNavigateToTaskScreen: (Long) -> Unit,
    calendarViewModel: CalendarViewModel = koinViewModel(),
    calendarUtil: CalendarUtil = koinInject(),
) {
    val uiState by calendarViewModel.uiState.collectAsStateWithLifecycle()

    var calendar by remember {
        mutableStateOf(calendarUtil.getDay(lastSelectedDay = calendarUtil.today))
    }

    LaunchedEffect(key1 = calendar.selectedDay.date) {
        calendarViewModel.fetchAllTasksByPlannedAt(calendar.selectedDay.date)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        CalendarHeader(
            modifier = Modifier.fillMaxWidth(),
            calendar = calendar,
            onPreviousClick = { day ->
                calendar = calendarUtil.getDay(
                    firstDay = day.minusDays(1),
                    lastSelectedDay = calendar.selectedDay.date
                )
            },
            onNextClick = { day ->
                calendar = calendarUtil.getDay(
                    firstDay = day.plusDays(2),
                    lastSelectedDay = calendar.selectedDay.date
                )
            },
        )
        Spacer(modifier = Modifier.height(10.dp))
        CalendarDayList(
            modifier = Modifier.fillMaxWidth(),
            calendar = calendar,
            onDaySelect = { selectedDay ->
                calendar = calendar.copy(
                    selectedDay = selectedDay,
                    weekDays = calendar.weekDays.map { day ->
                        day.copy(isSelected = day.date.isEqual(selectedDay.date))
                    }
                )
            },
        )
        when {
            uiState.isLoading -> {
                LoadingContent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                )
            }

            uiState.tasks.isEmpty() -> {
                EmptyContent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                )
            }

            uiState.tasks.isNotEmpty() -> {
                CalendarContent(
                    modifier = Modifier.weight(1f),
                    tasks = uiState.tasks,
                    onNavigateToTaskScreen = onNavigateToTaskScreen,
                )
            }
        }
    }
}