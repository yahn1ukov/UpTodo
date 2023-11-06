package ua.yahniukov.uptodo.presentation.screens.home.calendar.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ua.yahniukov.uptodo.utils.Calendar

@Composable
fun CalendarDayList(
    modifier: Modifier = Modifier,
    calendar: Calendar,
    onDaySelect: (Calendar.Day) -> Unit,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        items(items = calendar.weekDays) { day ->
            CalendarDayListItem(
                day = day,
                onDaySelect = onDaySelect,
            )
        }
    }
}