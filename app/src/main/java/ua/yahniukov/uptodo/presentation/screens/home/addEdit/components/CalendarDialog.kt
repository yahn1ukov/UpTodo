package ua.yahniukov.uptodo.presentation.screens.home.addEdit.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ua.yahniukov.uptodo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarDialog(
    state: DatePickerState,
    onPlannedAtChange: (Long) -> Unit,
    onCalendarDialogShow: (Boolean) -> Unit,
) {
    DatePickerDialog(
        onDismissRequest = { onCalendarDialogShow(false) },
        dismissButton = {
            TextButton(onClick = { onCalendarDialogShow(false) }) {
                Text(text = stringResource(R.string.cancel_btn))
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onCalendarDialogShow(false)
                onPlannedAtChange(state.selectedDateMillis!!)
            }) {
                Text(text = stringResource(R.string.save_btn))
            }
        },
    ) {
        DatePicker(
            state = state,
            showModeToggle = false,
        )
    }
}