package ua.yahniukov.uptodo.presentation.screens.home.calendar.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ua.yahniukov.uptodo.R
import ua.yahniukov.uptodo.utils.Calendar
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun CalendarHeader(
    modifier: Modifier = Modifier,
    calendar: Calendar,
    onPreviousClick: (LocalDate) -> Unit,
    onNextClick: (LocalDate) -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { onPreviousClick(calendar.firstDay.date) }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = stringResource(R.string.left_btn),
            )
        }
        Text(
            text = if (calendar.selectedDay.isToday) {
                stringResource(R.string.today)
            } else {
                calendar.selectedDay.date.format(
                    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                )
            }
        )
        IconButton(onClick = { onNextClick(calendar.lastDay.date) }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(R.string.right_btn),
            )
        }
    }
}