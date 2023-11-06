package ua.yahniukov.uptodo.presentation.screens.home.settings.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ua.yahniukov.uptodo.R

@Composable
fun DeleteAllTasksButton(onDeleteAllDialogShow: (Boolean) -> Unit) {
    ElevatedButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onDeleteAllDialogShow(true) },
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color.Red,
            contentColor = Color.White,
        ),
    ) {
        Text(text = stringResource(R.string.delete_all_tasks_btn))
    }
}