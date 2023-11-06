package ua.yahniukov.uptodo.presentation.screens.home.task.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.yahniukov.uptodo.R
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity
import ua.yahniukov.uptodo.presentation.components.Chip

@Composable
fun TaskContent(
    modifier: Modifier = Modifier,
    task: TaskEntity,
) {
    Column(modifier = modifier) {
        Text(
            text = task.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Justify,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Chip(
            icon = painterResource(R.drawable.ic_flag),
            iconSize = 16.dp,
            label = task.priority.toString(),
            labelSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        task.plannedAt?.let {
            Text(
                text = stringResource(R.string.planned_at, it),
                fontSize = 13.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
        Text(
            text = stringResource(R.string.created_at, task.createdAt),
            fontSize = 13.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = task.description,
            textAlign = TextAlign.Justify,
        )
    }
}