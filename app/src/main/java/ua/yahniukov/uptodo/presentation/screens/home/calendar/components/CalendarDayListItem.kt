package ua.yahniukov.uptodo.presentation.screens.home.calendar.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.yahniukov.uptodo.utils.Calendar

@Composable
fun CalendarDayListItem(
    day: Calendar.Day,
    onDaySelect: (Calendar.Day) -> Unit,
) {
    Card(
        modifier = Modifier.clickable { onDaySelect(day) },
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(
            width = 1.dp,
            color = if (day.isSelected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.outline
            },
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (day.isSelected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.background
            },
        ),
    ) {
        Column(
            modifier = Modifier
                .width(46.dp)
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = day.abbreviatedDate.uppercase(),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
            )
            Text(
                text = day.date.dayOfMonth.toString(),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}