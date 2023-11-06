package ua.yahniukov.uptodo.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.yahniukov.uptodo.R
import ua.yahniukov.uptodo.data.local.models.entities.TaskEntity

@Composable
fun TaskListItem(
    modifier: Modifier = Modifier,
    task: TaskEntity,
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary,
        ),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = task.title,
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = if (task.plannedAt != null) {
                    Arrangement.SpaceBetween
                } else {
                    Arrangement.End
                },
            ) {
                task.plannedAt?.let {
                    Text(
                        text = it.toString(),
                        fontSize = 12.sp,
                    )
                }
                Chip(
                    icon = painterResource(R.drawable.ic_flag),
                    label = task.priority.toString(),
                )
            }
        }
    }
}