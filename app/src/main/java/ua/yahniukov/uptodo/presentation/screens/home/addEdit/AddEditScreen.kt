package ua.yahniukov.uptodo.presentation.screens.home.addEdit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ua.yahniukov.uptodo.R
import ua.yahniukov.uptodo.presentation.screens.home.addEdit.components.AddEditTopAppBar
import ua.yahniukov.uptodo.presentation.screens.home.addEdit.components.CalendarDialog
import ua.yahniukov.uptodo.presentation.screens.home.addEdit.components.DescriptionTextField
import ua.yahniukov.uptodo.presentation.screens.home.addEdit.components.PriorityField
import ua.yahniukov.uptodo.presentation.screens.home.addEdit.components.TitleTextField
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditScreen(
    taskId: Long,
    onNavigateToBack: () -> Unit,
    addEditViewModel: AddEditViewModel = koinViewModel(),
) {
    val addEditTaskDto by addEditViewModel.addEditTaskDto.collectAsState()

    var isCalendarDialogShow by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Calendar.getInstance().timeInMillis,
    )

    LaunchedEffect(key1 = taskId) {
        if (taskId != -1L) {
            addEditViewModel.fetchTaskById(taskId)
        }
    }

    Scaffold(
        topBar = {
            AddEditTopAppBar(onNavigateToBack = onNavigateToBack)
        }
    ) { padding ->
        if (isCalendarDialogShow) {
            CalendarDialog(
                state = datePickerState,
                onPlannedAtChange = { addEditViewModel.updatePlannedAt(it) },
                onCalendarDialogShow = { isCalendarDialogShow = it },
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
        ) {
            TitleTextField(
                modifier = Modifier.fillMaxWidth(),
                title = addEditTaskDto.title,
                onTitleChange = { addEditViewModel.updateTitle(it) },
            )
            Spacer(modifier = Modifier.height(12.dp))
            DescriptionTextField(
                modifier = Modifier.fillMaxWidth(),
                description = addEditTaskDto.description,
                onDescriptionChange = { addEditViewModel.updateDescription(it) },
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = stringResource(R.string.priority))
            Spacer(modifier = Modifier.height(6.dp))
            PriorityField(
                modifier = Modifier.fillMaxWidth(),
                priority = addEditTaskDto.priority,
                onPriorityChange = { addEditViewModel.updatePriority(it) },
            )
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                IconButton(onClick = { isCalendarDialogShow = true }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_calendar_outlined),
                        contentDescription = stringResource(R.string.calendar),
                    )
                }
                IconButton(onClick = {
                    if (taskId != -1L) {
                        addEditViewModel.updateTask()
                    } else {
                        addEditViewModel.createTask()
                    }
                    onNavigateToBack()
                }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_send),
                        contentDescription = stringResource(R.string.create),
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
            }
        }
    }
}