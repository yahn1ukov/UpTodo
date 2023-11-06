package ua.yahniukov.uptodo.utils

import java.time.LocalDate

data class Calendar(
    val selectedDay: Day,
    val weekDays: List<Day>,
) {
    val firstDay: Day = weekDays.first()
    val lastDay: Day = weekDays.last()

    data class Day(
        val date: LocalDate,
        val abbreviatedDate: String,
        val isSelected: Boolean,
        val isToday: Boolean,
    )
}