package ua.yahniukov.uptodo.presentation.screens.home.addEdit.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.yahniukov.uptodo.R
import ua.yahniukov.uptodo.presentation.components.Chip

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PriorityField(
    modifier: Modifier = Modifier,
    priority: Int,
    onPriorityChange: (Int) -> Unit,
) {
    FlowRow(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        maxItemsInEachRow = 5,
    ) {
        repeat(10) { index ->
            Chip(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onPriorityChange(index + 1) },
                icon = painterResource(R.drawable.ic_flag),
                iconSize = 16.dp,
                label = "${index + 1}",
                labelSize = 14.sp,
                containerColor = if (priority == (index + 1)) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.background
                },
                borderColor = if (priority == (index + 1)) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.outline
                }
            )
        }
    }
}