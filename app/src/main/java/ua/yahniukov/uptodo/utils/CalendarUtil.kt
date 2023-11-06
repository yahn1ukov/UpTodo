package ua.yahniukov.uptodo.utils

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CalendarUtil {
    val today: LocalDate = LocalDate.now()

    fun getDay(firstDay: LocalDate = today, lastSelectedDay: LocalDate): Calendar {
        val firstDayOfWeek = firstDay.with(DayOfWeek.MONDAY)
        val lastDayOfWeek = firstDayOfWeek.plusDays(7)
        val weekDays = generateDayRange(firstDayOfWeek, lastDayOfWeek)
        return createCalendar(weekDays, lastSelectedDay)
    }

    private fun generateDayRange(firstDay: LocalDate, lastDay: LocalDate): List<LocalDate> {
        return generateSequence(firstDay) { it.plusDays(1) }
            .takeWhile { it < lastDay }
            .toList()
    }

    private fun createCalendar(weekDays: List<LocalDate>, lastSelectedDay: LocalDate): Calendar {
        return Calendar(
            selectedDay = toDay(lastSelectedDay, true),
            weekDays = weekDays.map { toDay(it, it == lastSelectedDay) }
        )
    }

    private fun toDay(currentDay: LocalDate, isSelectedDay: Boolean): Calendar.Day {
        return Calendar.Day(
            date = currentDay,
            abbreviatedDate = currentDay.format(DateTimeFormatter.ofPattern("E")),
            isSelected = isSelectedDay,
            isToday = currentDay == today,
        )
    }
}